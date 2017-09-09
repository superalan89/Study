
public class Change {
	/*
	int changeArray[] = {5000, 1000, 500, 100, 50, 10};
	/*
	public void calc(int pay, int buy) {
		int change = pay - buy;
		
	    System.out.printf("�Ž����� = %d \n", change);
	    int temp = change/5000;
	    System.out.printf("5000�� = %d \n", temp);
	    change = change % 5000;
	    System.out.println(change);
	    temp = change/1000;
	}
	*/
	
	
	/*
	public void calc(int pay, int buy) {
		int change = pay - buy;
		print ("�ѰŽ�����", change);
		
		for (int money : changeArray) {
	    print(money + "", change/money);
	    change = change % money;
		}
	}
	
	public void print(String flag, int count) {
		System.out.printf("%s�� = %d \n", flag, count);
	}
	*/
	
	
int changeArray[] = {100000, 50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) {
		Change change = new Change();
		change.cal(125000, 300);
	}

	public void cal(int pay, int price) {	
		int gross = pay - price;
		showChange("�� �Ž�����", gross);
		System.out.println();
		
		for(int money : changeArray) {
			if(gross / money == 0) 
				continue;
			showChange(money, gross/money);
			gross %= money;
		}
		
	}
	
	public void showChange(String str, int i) {
		System.out.printf("%s : %d�� \n", str, i);
	}
	
	public void showChange(int money, int i) {
		System.out.printf("%s : %d�� \n", money, i);
	}
}