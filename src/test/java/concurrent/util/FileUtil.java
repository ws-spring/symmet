package concurrent.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileUtil {
    public static byte[] getBytes(File f) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 4096;
            byte[] buffer = new byte[buf_size];
            int len;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* 把一个Map写入文件中 */
    public static <K, V> void writeMapToFile(String fileName, Map<K, V> map) {
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            for (Map.Entry<K, V> entry : map.entrySet())
                fw.write(entry.getKey().toString() + ":" + entry.getValue().toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}