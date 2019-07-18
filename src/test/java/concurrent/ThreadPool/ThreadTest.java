package concurrent.ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池ThreadPoolExecutor与ForkJoinPool:
 * https://blog.csdn.net/qq_25224749/article/details/81146556
 *
 * @author hp
 * @version 1.0, 2019年7月18日
 */
public class ThreadTest
{
    public static void main(String[] args) throws InterruptedException
    {
        /**
         * corePoolSize：核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
         * maximumPoolSize：线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；
         * keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        long s1 = System.currentTimeMillis();
        // 计数控制
        final CountDownLatch latch = new CountDownLatch(330);
        for (int i = 0; i < 330; i++)
        {
            // 自定义执行体
            MyTask myTask = new MyTask(i, latch);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
                    + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        // 控制所有线程全部跑完（异步执行可以去掉）
        latch.await();
        long s2 = System.currentTimeMillis();
        long s = s2 - s1;
        System.out.println("线程池执行时间:" + s);
        System.out.println("执行完毕=============================");
        executor.shutdown();
    }
}

class MyTask implements Runnable
{
    private int taskNum;

    private CountDownLatch latch;

    public MyTask(int num, CountDownLatch latch)
    {
        this.taskNum = num;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        System.out.println("正在执行task " + taskNum);
        try
        {
            Thread.currentThread().sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            latch.countDown();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}
