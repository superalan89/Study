package oop11.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Ctrl+Shift+O(알파벳)  로 필요한 임포트를 바로 넣어줄 수 있다. 필요없는건 알아서 제거해줌.

/*
 * List의 특징
 *  1. 저장순서 유지
 *  2. 데이터 중복 허용
 */

public class ApiTest02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("한가인");
		list.add("전지현");
		list.add("한가인");
		list.add("김태희");
		list.add("이민정");
		
		System.out.println(list.size());
		
		/*Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}*/
		
		/*for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		for(String str : list) {
			System.out.println(str);
		}
		
	}
}
