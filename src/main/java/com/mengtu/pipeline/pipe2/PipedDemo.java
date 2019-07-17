package com.mengtu.pipeline.pipe2;

import java.io.* ;

/**
 * JAVA的IO编程：管道流:https://www.cnblogs.com/alsf/p/6785592.html
 * 
 * help：
 * 
 * 还要并行度，最土的方法是将文件每次请求的大小降低到一定程度，如8K(这个大小是经过测试后网络传输较为适宜的大小，本地读取文件并不需要这么小)，如果再做深入一些，可以做一定程度的cache，将多个请求的一样的文件，cache在内存或分布式缓存中，你不用将整个文件cache在内存中，将近期使用的cache几秒左右即可，或你可以采用一些热点的算法来配合;类似迅雷下载的断点传送中(不过迅雷的网络协议不太一样)，它在处理下载数据的时候未必是连续的，只要最终能合并即可，在服务器端可以反过来，谁正好需要这块的数据，就给它就可以;才用NIO后，可以支持很大的连接和并发，本地通过NIO做socket连接测试，100个终端同时请求一个线程的服务器，正常的WEB应用是第一个文件没有发送完成，第二个请求要么等待，要么超时，要么直接拒绝得不到连接，改成NIO后此时100个请求都能连接上服务器端，服务端只需要1个线程来处理数据就可以，将很多数据传递给这些连接请求资源，每次读取一部分数据传递出去，不过可以计算的是，在总体长连接传输过程中总体效率并不会提升，只是相对相应和所开销的内存得到量化控制，这就是技术的魅力，也许不要太多的算法，不过你得懂他。
 *
 * @author hp
 * @version 1.0, 2019年7月10日
 */
class Send implements Runnable{            // 线程类
    private PipedOutputStream pos = null ;    // 管道输出流
    public Send(){
        this.pos = new PipedOutputStream() ;    // 实例化输出流
    }
    public void run(){
        String str = "Hello World!!!" ;    // 要输出的内容
        try{
            this.pos.write(str.getBytes()) ;
        }catch(IOException e){
            e.printStackTrace() ;
        }
        try{
            this.pos.close() ;
        }catch(IOException e){
            e.printStackTrace() ;
        }
    }
    public PipedOutputStream getPos(){    // 得到此线程的管道输出流
        return this.pos ;    
    }
};
class Receive implements Runnable{
    private PipedInputStream pis = null ;    // 管道输入流
    public Receive(){
        this.pis = new PipedInputStream() ;    // 实例化输入流
    }
    public void run(){
        byte b[] = new byte[1024] ;    // 接收内容
        int len = 0 ;
        try{
            len = this.pis.read(b) ;    // 读取内容
        }catch(IOException e){
            e.printStackTrace() ;
        }
        try{
            this.pis.close() ;    // 关闭
        }catch(IOException e){
            e.printStackTrace() ;
        }
        System.out.println("接收的内容为：" + new String(b,0,len)) ;//注意，这里是把读入的数组的数据输出，而不是PipeInputStream实例对象输出，
    }
    public PipedInputStream getPis(){
        return this.pis ;
    }
};
public class PipedDemo{
    public static void main(String args[]){
        Send s = new Send() ;
        Receive r = new Receive() ;
        try{
            s.getPos().connect(r.getPis()) ;    // 连接管道
        }catch(IOException e){
            e.printStackTrace() ;
        }
        new Thread(s).start() ;    // 启动线程
        new Thread(r).start() ;    // 启动线程
    }
};