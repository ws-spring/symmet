package concurrent.forkjoin;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
 
 
public class High {
 
    int[] nums = new int[1000];
    int CI = 10000;//计算多少次
    Random r = new Random();
 
    public High() {
        for (int i =1; i < nums.length; i++) {
            nums[i-1] = i;
        }
    }
 
    public static void main(String[] args) throws IOException {
        Arrays.stream(new int[3]).sum();//初始化sum内部排除初始化时间
 
        High t = new High();
        t.aa();
        t.bb();
        t.cc();
    }
 
    public void aa() {
 
 
        long start = System.currentTimeMillis();
        long n = 0;
        for(int i = 0; i< CI; i++) {
            n = Arrays.stream(nums).sum();
        }
        long end = System.currentTimeMillis();
        System.out.println("aa|"+ (end - start )+ "ms|" + n);
    }
 
    public void bb() {
        long start = System.currentTimeMillis();
        long n = 0;
        for(int j = 0; j< CI; j++) {
            n = 0;
            for (int i = 0; i < nums.length; i++) {
                n += nums[i];
            }
        }
 
        long end = System.currentTimeMillis();
        System.out.println("aa|"+ (end - start )+ "ms|" + n);
    }
 
 
    public void cc() throws IOException {
        ForkJoinPool pool = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        long start = System.currentTimeMillis();
        for(int j = 0; j< CI; j++) {
            pool.execute(task);
        }
 
        long s = task.join();
        long end = System.currentTimeMillis();
 
        System.out.println("aa|"+ (end - start )+ "ms|" + s);
        System.in.read();
    }
 
    class AddTask extends RecursiveTask<Long>{
 
        int start;
        int end;
 
        public AddTask(int s,int e){
            this.start = s;
            this.end = e;
        }
 
        @Override
        protected Long compute() {
 
            if(end - start <= 50000){
                long sum = 0L;
                for(int i = start;i< end ;i++){
                    sum += nums[i];
 
                }
                return sum;
            }
            int m = start +(end-start)/2;
 
            AddTask sub1 = new AddTask(start,m);
            AddTask sub2 = new AddTask(m,end);
            sub1.fork();
            sub2.fork();
 
            return sub1.join()+sub2.join();
 
        }
    }
 
}

