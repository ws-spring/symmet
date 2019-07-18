package concurrent.forkjoin;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


public class ForkJoinOne extends RecursiveTask<Long>
{
    private static final long serialVersionUID = 1L;
    //阈值
    private static final int THRESHOLD = 2;
    private Long start;
    private Long end;
    
    public ForkJoinOne(Long start, Long end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute()
    {
        Long sum = 0L;
        //判断任务是否足够小
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute)
        {
            //如果小于阈值，就进行运算
            for(Long i=start; i<=end; i++)
            {
                sum += i;
            }
        }
        else
        {
            //如果大于阈值，就再进行任务拆分
        	Long middle = (start + end)/2;
            ForkJoinOne leftTask = new  ForkJoinOne(start,middle);
            ForkJoinOne rightTask = new  ForkJoinOne(middle+1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到执行结果
            Long leftResult = leftTask.join();
            Long rightResult = rightTask.join();
            //合并子任务
            sum = 0L+leftResult + rightResult;
            
        }
        return sum;
    }
    
    public static void main(String[] args)
    {
        Long total1=1000L;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long start=System.currentTimeMillis();
        ForkJoinOne task = new ForkJoinOne(1L,total1);
        //执行一个任务
        Future<Long> result = forkJoinPool.submit(task);
        Long end1=0L;
        try
        {
            System.out.println(result.get());
            end1=System.currentTimeMillis();
            System.out.println("结果1===="+(end1-start));
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        Long start2=System.currentTimeMillis();
        Long total=0L;
        for (int i = 1; i <= total1; i++)
        {
            total+=i;
        }
        System.out.println("值----"+total);
        Long end2=System.currentTimeMillis();
        System.out.println("结果2===="+(end2-start2));
        
    }
}
