package symmet;

public class ParallelOne
{
        public class Pi_thread extends Thread{
            
            private int start_wy;
            private int num_steps_wy=100000000;
            double step,x,sum = 0.0;
            public Pi_thread(int start)
            {
               this.start_wy=start;
            }
            public void run() 
           {
             
             int i;
             step=1.0/(double)num_steps_wy;
             for(i=start_wy;i<num_steps_wy;i+=2)
             {
              x=(i+0.5)*step;
              sum=sum+4.0/(1.0+x*x);
             }
            
            }
            public void seril_pi()
            {
             int i;
             step=1.0/(double)num_steps_wy;
             for(i=1;i<num_steps_wy;i++)
             {
              x=(i+0.5)*step;
              sum=sum+4.0/(1.0+x*x);
             }
            }
            
            public static void main(String[] args) throws InterruptedException {
            
             double pi_wy,sum_wy=0.0,seri_t_wy,para_t_wy;
            
            
             Pi_thread thread1=new Pi_thread(1);
             Pi_thread thread2=new Pi_thread(2);
            
             double t1=System.currentTimeMillis();
            
             thread1.start();
             thread2.start();
             thread1.join();
             thread2.join();
            
             double t2=System.currentTimeMillis();
            
             sum_wy=thread1.sum+thread2.sum;
             pi_wy=thread1.step*sum_wy;
             para_t_wy=t2-t1;
             System.out.println("并行结果: "+pi_wy);
             System.out.println("并行时间: "+para_t_wy);
             
             Pi_thread thread3=new Pi_thread(3);
            
             t1=System.currentTimeMillis();
            
             thread3.seril_pi();
            
             t2=System.currentTimeMillis();
            
             pi_wy=thread3.sum*thread3.step;
            
             seri_t_wy=t2-t1;
             System.out.println("窜行结果： "+pi_wy);
             System.out.println("串行时间： "+seri_t_wy);
             System.out.println("加速比： "+(seri_t_wy/para_t_wy));
             
            }
            
           }
}
