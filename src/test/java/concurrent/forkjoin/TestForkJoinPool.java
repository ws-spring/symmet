package concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**java的Fork-Join分治编程效率问题:http://www.yayihouse.com/yayishuwu/chapter/1500
 * 这是一个简单的Join/Fork计算过程，将1—1001数字相加
 */
public class TestForkJoinPool {
 
    private static final Integer MAX = 5000;
 
    static class MyForkJoinTask extends RecursiveTask<Long> {
        // 子任务开始计算的值
        private Long startValue;
 
        // 子任务结束计算的值
        private Long endValue;
 
        public MyForkJoinTask(Long startValue , Long endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }
 
        @Override
        protected Long compute() {
            // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
            // 可以正式进行累加计算了
        	
            if(endValue - startValue < MAX) {
               // System.out.println("开始计算的部分：startValue = " + startValue + ";endValue = " + endValue);
            	Long totalValue = 0L;
                for(Long index = this.startValue ; index <= this.endValue  ; index++) {
                    totalValue += index;
                    for (int j = 1; j <= 1000000000; j++);
                }
                return totalValue;
            }
            // 否则再进行任务拆分，拆分成两个任务
            else {
                MyForkJoinTask subTask1 = new MyForkJoinTask(startValue, (startValue + endValue) / 2);
                subTask1.fork();
                MyForkJoinTask subTask2 = new MyForkJoinTask((startValue + endValue) / 2 + 1 , endValue);
                subTask2.fork();
                for (int j = 1; j <= 1000000000; j++);
                return subTask1.join() + subTask2.join();
            }
        }
    }
 
    public static void main(String[] args) {
        // 这是Fork/Join框架的线程池   99000L
    	Long total1=1800L;
        try {
        	ForkJoinPool pool = new ForkJoinPool();
        	Long start1=System.currentTimeMillis();
        	Long total=0L;
			ForkJoinTask<Long> taskFuture =  pool.submit(new MyForkJoinTask(1L,total1));
			total+=taskFuture.get();
        	Long ens2=System.currentTimeMillis();
        	 System.out.println("值1----"+total);
        	System.out.println(ens2-start1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
        Long start2=System.currentTimeMillis();
        Long total=0L;
    	for (int i = 1; i <= total1; i++)
    	{
    		total+=i;
    		for (int j = 1; j <= 1000000000; j++);
    	}
        System.out.println("值2----"+total);
        Long end2=System.currentTimeMillis();
        System.out.println("结果2===="+(end2-start2));
    }

}
