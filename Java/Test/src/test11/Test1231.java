package test11;

import java.util.ArrayList;
import java.util.List;

public class Test1231 {
	
	public static void main(String[] args) {
		Test1231 test = new Test1231();
		int[] a = {1, 3, 2, 1};
		System.out.println(test.almostIncreasingSequence(a));
	}
	boolean almostIncreasingSequence(int[] seq) {
	    List<Integer> list = new ArrayList<>();
	    for(int i = 0; i < seq.length; i++) {
	        list.add(seq[i]);
	    }

	    int difCount = 0;
	    for(int i= 0; i<list.size()-1; i++) {
	        if(list.get(i)> list.get(i+1)) {
	            difCount++;
	            if(list.get(i) > list.get(i+2)) {
	                list.remove(i);
	                i=0;
	            } else {
	                list.remove(i+1);
	            } 
	        }  
	    }
	    if(difCount > 1) return false;
	    return true;
	}
}
