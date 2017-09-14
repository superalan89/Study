package School;

import com.java.main;

public class ArrayList {
	
	public static void main(String[] args) {
	
		int[] student = new int [10];
		ArrayList<Integer> students = new ArrayList();
		
		students.add(1);
		students.add(2);
		students.add(3);
		students.add(4);
		students.add(5);
		students.add(7);
		students.add(8);
		
		students.add(0);
		
		for(int i = 0 ; i < students.size() ; i++) {
			System.out.println(i);
		}
	}
}
