package concurrent.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
		ConcurrentHashMap cMap=new ConcurrentHashMap();
		Map  hMap=new HashMap<>(100000000);
		int total=100000;
        Long start=System.currentTimeMillis();
        	for (int i = 0; i < total; i++)
        	{
        		cMap.put(i, i);
        	}
        Long end1=System.currentTimeMillis();
        System.out.println("cMap:"+(end1-start));
        for (int j = 0; j < total; j++)
          {
        	hMap.put(j, j);
          }
        Long end2=System.currentTimeMillis();
        System.out.println("hMap:"+(end2-end1));
	}
}
