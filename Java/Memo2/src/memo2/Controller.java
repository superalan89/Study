package memo2;

import java.util.Scanner;
import java.util.List;

public class Controller {
	
	View view;
	Model model;
	Memo memo;
	
	public static boolean RUN = true;

	public Controller() {
		view = new View();
		model = new Model();
	}
	
	public void run() {
		while(RUN) {
			String std = view.intro();
			switch(std) {
			case "c" :
				memo = view.create();
				memo.date = System.currentTimeMillis();
				model.data.add(memo);
				break;
			case "r" :
				index = view.readMemo();
				memo = model.getMemo(index);
				view.showMemo(memo);
				break;
			case "u" :
				Memo memo = view.updateMemo();
				model.update(memo);
				break;
			case "d" :
				break;
			case "l" :
				break;
			case "x" :
				break;
			}
		}
		
	}
		
}

