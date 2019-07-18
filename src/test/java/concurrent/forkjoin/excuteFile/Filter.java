package concurrent.forkjoin.excuteFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

import concurrent.util.FileUtil;
/**
 * ForkJoin并行处理文件：
 *          https://blog.csdn.net/u013262051/article/details/51541627
 *
 * @author hp
 * @version 1.0, 2019年7月18日
 */
public class Filter {
    static ForkJoinPool mPool = null;
    static List<File> mList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
            /* 指定并行执行所需线程数量 eg (-j 8) 指定线程池有8个线程*/
                case "-j":
                    mPool = new ForkJoinPool(Integer.parseInt(args[++i]));
                    break;

            /* 指定顶级目录列表 */
                default:
                    mList.add(new File(args[i]));
                    break;
            }
        }

        /* 具体分配执行 */
        new Executor().invokeTask();
    }

/*
* 具体的顶级任务执行器
*/
    static class Executor {
        long start = 0;
        long end1 = 0;
        long end2 = 0;

        private List<GenMd5Task> mTasks = new ArrayList<>();
        private List<Map<String, String>> mapList = new ArrayList<>();

        public Executor() {
            if (mPool == null) {
                mPool = new ForkJoinPool();
            }
        }

        public List<Map<String, String>> invokeTask() {
            end1 = end2 = start = System.currentTimeMillis();

            for (File file : mList) {
                /* 划分的子任务*/ 
                GenMd5Task task = new GenMd5Task(file);
                mTasks.add(task);
                /* 调用任务并等待返回执行结果 */
                Map<String, String> map = mPool.invoke(task);
                mapList.add(map);

                end1 = System.currentTimeMillis();

                /* 把最终计算结果记录到文件中 */ 
                FileUtil.writeMapToFile(file.getName() + System.currentTimeMillis() + "-md5.txt",
                        map);

                end2 = System.currentTimeMillis();
            }

            /* 统计耗时 */
            System.out.println("computer time: " + (end1 - start) + "ms");
            System.out.println("write file time: " + (end2 - end1) + "ms");

            mPool.shutdown();

            return mapList;
        }
    }
}
