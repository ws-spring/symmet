package concurrent.forkjoin.excuteFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import ch.qos.logback.core.util.FileUtil;

public class GenMd5Task extends RecursiveTask<Map<String, String>> {
    private HashMap<String, String> mMap;
    private File mFile;
    private List<GenMd5Task> mTasks;

    public GenMd5Task(File file) {
        mFile = file;
    }

    @Override
    protected Map<String, String> compute() {
        mMap = new HashMap();
        File[] files = mFile.listFiles();
        mTasks = new ArrayList<>();

        for (File f : files) {
            System.out.println(f.getAbsoluteFile());
            if (f.isFile()) {
                mMap.put(DigestUtil.getMd5(FileUtil.getBytes(f)), f.getAbsolutePath());
            } else {
                /* 上边是文件直接计算MD5放进当前结果Map中 */
                /* 下边是当前目录一级子目录，再次创建一个子任务，添加进任务列表，一会并发执行这些任务 */ 
                GenMd5Task task = new GenMd5Task(f);
                mTasks.add(task);
            }
        }

        /* 执行所有任务 并汇总结果*/ 
        invokeAll(mTasks);
        for (GenMd5Task task : mTasks) {
            mMap.putAll(task.join());
        }

        return mMap;
    }
}