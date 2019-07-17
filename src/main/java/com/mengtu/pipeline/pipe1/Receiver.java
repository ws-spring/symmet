package com.mengtu.pipeline.pipe1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.List;

import com.mengtu.Person;

@SuppressWarnings ("all")
/**
 * 接收者线程
 */
public class Receiver extends Thread
{

    // 管道输入流对象。
    // 它和“管道输出流(PipedOutputStream)”对象绑定，
    // 从而可以接收“管道输出流”的数据，再让用户读取。
    private PipedInputStream in = new PipedInputStream();

    // 获得“管道输入流”对象
    public PipedInputStream getInputStream()
    {
        return in;
    }

    @Override
    public void run()
    {
        // readMessageOnce() ;
        List<Person> pList = new ArrayList<Person>();
        String res=readMessageContinued();
//        pList=new Gson().
    }

    // 从“管道输入流”中读取1次数据
    public void readMessageOnce()
    {
        // 虽然buf的大小是2048个字节，但最多只会从“管道输入流”中读取1024个字节。
        // 因为，“管道输入流”的缓冲区大小默认只有1024个字节。
        byte[] buf = new byte[2048];
        try
        {
            int len = in.read(buf);
            System.out.println(new String(buf, 0, len));
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // 从“管道输入流”读取>1024个字节时，就停止读取
    public String readMessageContinued()
    {
        int total = 0;
        String res=null;
        while (true)
        {
            byte[] buf = new byte[1024];
            try
            {
                int len = in.read(buf);
                total += len;
                res=new String(buf, 0, len);
                // 若读取的字节总数>1024，则退出循环。
                if (total > 1024)
                    break;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
