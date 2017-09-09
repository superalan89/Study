package oop11.api;
/*
 * Set의 특징
 *  1. 저장순서 기억하지 않음
 *  2. 중복된 데이터 허용 X
 */
import java.util.HashSet;
import java.util.Iterator;

public class ApiTest01 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();	//String 집어넣기 = generate
		set.add("한가인");
		set.add("전지현");
		set.add("한가인");
		set.add("김태희");
		set.add("이민정");
		
		System.out.println(set.size());
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
