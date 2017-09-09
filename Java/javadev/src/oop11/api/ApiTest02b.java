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

public class ApiTest02b {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("한가인"); printList(list);
		list.add("전지현"); printList(list);
		list.add("한가인"); printList(list);
		list.add("김태희"); printList(list);
		list.add("이민정"); printList(list);
		
		list.add(2, "이영애"); printList(list);
		list.remove("이민정"); printList(list);  //제거
		list.remove("한가인"); printList(list);  //제거
		list.remove(1); printList(list);  //제거
		
		list.set(1, "한효주"); printList(list);  //교체
		list.add("김태희"); printList(list);
		list.add("이민정"); printList(list); 
		list.add("김태희"); printList(list);
		list.add("이민정"); printList(list); 
		
		System.out.println("김태희의 위치 : " + list.indexOf("김태희"));   //제일 왼쪽부터 검색 0 1 2 순으로
		System.out.println("김태희의 위치 : " + list.lastIndexOf("김태희"));   //제일 오른쪽부터 검색  
	}
	
	private static void printList(List<String> list) {
		System.out.print("size : " + list.size() + ",\t");
		for(String str : list) {
			System.out.print(str + "\t");
		}
		System.out.println();
	}
}
