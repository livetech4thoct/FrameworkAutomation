package dec22nd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		Map<Integer, String> hMap=new HashMap<Integer, String>();
		
		hMap.put(100, "John");
		
		hMap.put(101, "Sam");
		
		hMap.put(102, "David");
		
		hMap.put(103, "Ravi");
		
		System.out.println(hMap.size());
		
		System.out.println(hMap.keySet());
		
		System.out.println(hMap.values());
		
		System.out.println(hMap.get(100));
		System.out.println(hMap.get(101));
		System.out.println(hMap.get(102));
		System.out.println(hMap.get(103));
		
		Set<Entry<Integer, String>> entries=hMap.entrySet();
		
		for(Entry<Integer,String> temp:entries)
		{
			System.out.println(temp.getKey()+"----"+temp.getValue());
		}
		
		Iterator<Entry<Integer, String>> it=entries.iterator();
		  
		Entry<Integer, String> entry=null;
		while(it.hasNext())
		{
			entry=it.next();
			
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		
		
		
		
	}

}
