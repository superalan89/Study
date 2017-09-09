package memo2;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List<Memo> data = new ArrayList<>();
	
	public void addMemo(Memo memo) {
		memo.no = data.size()+1;
		data.add(memo);
	}
	
	public Memo getMemo(int index) {
		Memo temp = null;
		for(Memo memo : data) {
			if(memo.no == index) {
				temp = memo;
				return temp;
			} 
		}
		return null;
	}
	
	
	public void update(Memo memo) {
		data.set(memo.no-1, memo);
	}
}
