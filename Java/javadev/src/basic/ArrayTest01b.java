package basic;

public class ArrayTest01b {
	public static void main(String[] args) {
		//int[] arr = new int[]{100, 200, 300};
		int[] arr = {100, 200, 300};
		
		// 배열값을 미리 정할때 []안에 숫자는 입력하지 말 것
		
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//length 속성쓸때 등호 쓰지말것! 없는 숫자이기 때문
	}
}
