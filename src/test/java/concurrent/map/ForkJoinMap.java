package concurrent.map;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

import concurrent.forkjoin.ForkJoinOne;

public class ForkJoinMap extends RecursiveTask<ConcurrentHashMap>{
	
	@SuppressWarnings("rawtypes")
	ConcurrentHashMap map;
	public static  Map cMap;
	private static final long serialVersionUID = 1L;
    //阈值
    private static final int THRESHOLD = 200;
    private Integer start;
    private Integer end;
    
    public ForkJoinMap(Integer start, Integer end,ConcurrentHashMap map)
    {
        this.start = start;
        this.end = end;
        this.map=map;
    }

	@Override
	protected ConcurrentHashMap compute() {
        //判断任务是否足够小
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute)
        {
            //如果小于阈值，就进行运算
            for(int i=start; i<=end; i++)
            {
            	map.put(i, i);
            }
        }
        else
        {
            //如果大于阈值，就再进行任务拆分
        	int middle = (start + end)/2;
        	ForkJoinMap leftTask = new  ForkJoinMap(start,middle,map);
        	ForkJoinMap rightTask = new  ForkJoinMap(middle+1,end,map);
            //执行子任务
        	invokeAll(leftTask,rightTask);
            //等待子任务执行完，并得到执行结果
            map=leftTask.join();
           ConcurrentHashMap map1=rightTask.join();
            map1.putAll(rightTask.join());
        }
        return  map1;
	}
	public static void main(String[] args)
    {
        int total1=100000;
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Long start=System.currentTimeMillis();
        ForkJoinMap task = new ForkJoinMap(1,total1,new ConcurrentHashMap());
        //执行一个任务
        ConcurrentHashMap dd=forkJoinPool.invoke(task);;
        Long end=System.currentTimeMillis();
        System.out.println("结果1===="+(end-start));
//        System.out.println("值----"+total);
//        Long end2=System.currentTimeMillis();
        
    }

}
