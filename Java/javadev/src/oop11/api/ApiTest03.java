package oop11.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ApiTest03 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ÀüÁöÇö", "010-1111-1111");
		map.put("ÇÑÈ¿ÁÖ", "010-1111-2222");
		map.put("±èÅÂÈñ", "010-1111-3333");
		map.put("¼ÛÇı±³", "010-1111-4444");
		
		/*Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
		}*/
		
		for(String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
		
	}
}
