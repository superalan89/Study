package com.kyoungho.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionMain {

	public static void main(String[] args) {
		CollectionMain main = new CollectionMain();
		//main.checkArray();
		//main.checkGeneric();
		main.checkSet();
	}
	
	public void checkArray() {
		// 선언
		// 타입 이름[] = new 타입 [배열공간크기];
		// 기본형인 int, long 등은 공간을 할당하는 것만으로 기본값의 0을 할당
		int intArray[] = new int[10];
		System.out.println(intArray[7]);

		Item itemArray [] = new Item[10];
		int itemLength = itemArray.length;
		for(int i=0 ; i<itemLength ; i++) {
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[7].getMyName());
	}
	// index를 포함하는 동적 객체배열
	public void checkList() {
		// 선언은 일반 객체를 초기화 하는것과 같다
		ArrayList list = new ArrayList();
		
		// 입력
		list.add(new Item()); // <- ㅐ0번 index로 생성
		list.add(new Item()); // <- ㅐ1번 index로 생성
		
		// 조회		
		list.get(0); // <- index가 0번째인 값을 가져온다
		
		// 수정
		list.set(1, new Item()); // <- 1번 index의 아이템을 대체
		
		// add의 다른 방법
		list.add(1, new Item()); // <- 1번부터 이후의 아이템 index를 하나씩 증가시키고 자신이 1번으로 들어간다.
		
		// 삭제
		list.remove(1); // 삭제할 아이템의 index를 지정한다.
						// 삭제하면 다음 데이터들이 앞으로 한칸씩 이동해서 빈공간을 채운다.
	}
	public void checkGeneric() {
		// 제네릭을 사용하는 방법
		// 타입<제네릭타입> 변수이름; // <- 제네릭타입은 클래스만 가능
		ArrayList<Item> list = new ArrayList<>();
		
//		list.add(123);
//		list.add("Hello");
		list.add(new Item());
//		list.add(new Student());
		
		/*for(int i=0; i<list.size(); i++) {
			System.out.println();
		}*/
		
		for(Item item : list) {
			item.getMyName();
		}
	}
	
	// List와 유사한데 중복값을 허용하지 않는 동적 객체배열
	public void checkSet() {
		HashSet set = new HashSet();
		set.add("Hello");
		set.add("Good to see you");
		set.add("Hello");
		
		// set은 iterator 를 달아서 순서대로 처리해 줄 수 있다. 마치 list처럼
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	// Key, Value로 구성된 동적 객체배열
	public void checkMap() {
		// 선언
		HashMap<String, Integer> map = new HashMap<>();
		
		// 입력
		map.put("key01", 123456);
		map.put("key02", 123456789);
		
		// 조회
		System.out.println(map.get("key01"));
		
		// 맵을 반복문으로 처리하기
		Set<String> keys = map.keySet();
		
		for(String key : keys) {
			System.out.println(map.get(key));
		}
		
	}
}

class Item {
	private String myName = "지코";
	public String getMyName() {
		return myName;
	}

}

class Student {
	private String name = "student";
	public String getName() {
		return name;
	}
}