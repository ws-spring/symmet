package concurrent.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedAndHashMap
{
    public static void main(String[] args)
    {
        int total=20000000;
        Map  hMap1=new HashMap<>(100000000);
        Map  hMap2=new HashMap<>(100000000);
        Long start=System.currentTimeMillis();
        for (int i = 0; i < total; i++)
        {
            hMap1.put(i, i);
        }
        Long end1=System.currentTimeMillis();
        System.out.println("lMap"+(end1-start));
//        for (int j = 0; j < total; j++)
//        {
//            hMap2.put(j, j);
//        }
//        Long end2=System.currentTimeMillis();
//        System.out.println("lMap"+(end2-end1));
        
    }
}
