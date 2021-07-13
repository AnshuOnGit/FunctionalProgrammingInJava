package org.simple.lifeiseasy;

import java.util.Arrays;
import java.util.List;

public class IterationVsRecursion {

	public int sumTotalOfList(List<Integer> list) {
		int sum = 0;
		for (Integer element : list) {
			sum = sum + element;
			//element = element -1;
		}
		return sum;
	}

	
	public int sumTotalOfList1(List<Integer> list) {
		return sumTotalOfListRec(list, 0, 0);
	}
	private int sumTotalOfListRec(List<Integer> list, int sumAcc, int pos) {
		if (pos >= list.size()) {
			return sumAcc;
		} else {
			return sumTotalOfListRec(list, sumAcc + list.get(pos), pos + 1);
		}
	}
	
	public static void main(String[] args) {
		IterationVsRecursion obj = new IterationVsRecursion();
		System.out.println("using iteration sum of list =" +
		obj.sumTotalOfList(Arrays.asList(1,2,3,4,5)));
		
		System.out.println("using recursion sum of list =" +
				obj.sumTotalOfList1(Arrays.asList(1,2,3,4,5)));
		
		System.out.println("using streams "+ 
		Arrays.asList(1,2,3,4,5).stream().reduce((x,y) -> x+y));
	}

}
