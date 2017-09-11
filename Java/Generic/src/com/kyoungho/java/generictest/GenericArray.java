package com.kyoungho.java.generictest;

public class GenericArray<T> {

	private Object list[];
	
	public GenericArray() { //값을 넣지 않은 상태에서 사이즈 등의 체크를 할 수 있기 때문에
					   // 저장소를 초기화 해주는 작업이 필요하다.
		
		// if (Type instanceOf target)
		list = (T[]) new Object[1];
	}
	
	public void add(T item) {
		// 배열의 크기를 임시로 늘려서 사용
		Object tempList[] = new Object[size()+1];
		for (int i=0 ; i < list.length ; i++) {
			tempList[i] = list[i];
		}
		
		tempList[list.length] = item;
		list = tempList;
	}
	
	public void remove (int position) {
		// 배열의 크기를 임시로 늘려서 사용
		Object tempList[] = new Object[size()-1];
		
		// position 이전의 데이터를 임시공간으로 복사
		for (int i=0 ; i < position ; i++) {
			tempList[i] = list[i];
		}
		
		// position 이후의 데이터를 임시공간으로 복사
		for (int i = position+1 ; i<list.length ; i++) {
			tempList[i-1] = list[i];
		}
		list = tempList;
	}
	
	public int size() {
		return list.length-1;
	}
	
}

