import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/**
 * 로또번호 생성기를 개발
 * 
 * 6자리 1~45
 * 
 * */
public class AlgoMath {

	public int[] getLottoNumbers() {
	    int[] result = new int[6];     
		Random random = new Random();
	    
       for(int i = 0; i < 6; i++) {
    	   
    	   // random 함수에서 발생되는 난수는 중복될 수 잇다
    	   // 아래에제에서 결과값이 처음에 33이 나왔을 경우
    	   // 두번째 케이스에서도 33이 나올 수 있다.
    	   
    	   int temp = random.nextInt(45) + 1;
    	   result[i] = temp;
    	   
    	   
    	   // 중복값에 대한 예외처리
    	   for(int j = 0; j < i; j++) {
    		   if (temp == result[j]) {
    			   
    		   }
    	   }
       }
	    
		return result;
	}

	
	public int[] getlottonNumbers2() {
		int[] result = new int[6];
		
		Random random = new Random();
		int temp = 0;
		int cnt = 0;
		for(int i=0; i<result.length ; i++) {
			temp = random.nextInt(45)+1;
			if(cnt > 0) {
				for(int item : result) {
					while (item == temp) {
						temp = random.nextInt(45)+1;
					}
				}
			}
			result[cnt] = temp;
			cnt++;
		}		
		return result;
	}
	
	public ArrayList<Integer> getLottonumbers3() {
		ArrayList<Integer> result = new ArrayList<>();
		Set<Integer> treeSet = new TreeSet<>();
		Random random = new Random();
		
		// 동적 배열 - 크기를 제한하지 않는 객체 배열
		// 종류 : List, Set, Map
		// List = 인덱스와 값을 가지고 있는 배열
		// Set = 리스트와 유사한데 중복값이 입력되지 않는다
		// Map = 키와 값을 가지고 있는 동적 배열, 값의 중복이 허용된다.
		// Map map = new HashMap();
		//     map.put("키", 33);
		
		
		for( /*시작값*/; 6 > treeSet.size();) { /*세개의 식 모두 공난으로 둘 수 있음*/
			treeSet.add(random.nextInt(45)+1);
		}
		
		Iterator<Integer> iterator = treeSet.iterator();
		
		while(iterator.hasNext()) {
			result.add(iterator.next());
		}
		return result;
	}
	
	/**
	 * 아나그램 알고리즘
	 * 
	 * 두개의 문자열 입력을 받아서 두개의 관계가 아나그램 관계인지 확인하는
	 * 프로그램을 개발
	 * 
	 * option. 받은 문자열의 공백제거
	 * 1. 받은 문자열의 길이를 체크 -> 길이가 다르면 검사하지 않는다.
	 * 2. 받은 문자열을 정렬
	 * 3. 정렬된 문자열을 비교
	 * 
	 * cat -> act
	 * was it a cat i saw -> was it a cat is
	 * listen -> silent
	 * 
	 * */
	
	
	public boolean checkAnagram(String a, String b) {
		boolean result = false;
		
		// 대소문자 처리
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		// 공배제거
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		// 길이 비교
		if (a.length() != b.length()) {
			return false;
		} 
		
		// 정렬을 하기 위해서 char 배열로 변경
		char aTemp[] = a.toCharArray();
		char bTemp[] = b.toCharArray();
		
		// 캐릭터 배열 정렬
		Arrays.sort(aTemp);
		Arrays.sort(bTemp);
	
		// 문자열 비교후 리턴
		return Arrays.equals(aTemp, bTemp);
		}
	
		public void testMath() {
		
		// 절대값 구하기
		int a = Math.abs(-123);
		
		// 반올림
		long b = Math.round(123.5);
		
		// 올림
		double c = Math.ceil(343.1543);
		
		// 내림
		double d = Math.floor(563.8);
		
		Math.random();
		
		Random random = new Random(); // 0보다 크거나 같고 1보다 
		
		// 1부터 100사이의 랜덤한 숫자 가져오기
		random.nextInt(100); // -> 0~99 사이의 정수가 리턴
		int r = random.nextInt(100) + 1;
		
	}
	
}
