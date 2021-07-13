package org.simple.lifeiseasy;

import java.util.function.Function;

public class HigherOrderFunctionsImproved {
	
	public static void main(String[] args) {
		HigherOrderFunctionsImproved obj = new HigherOrderFunctionsImproved();
		System.out.println("sum of Numbers between 1 and 5 = " + obj.sumOfNumbers(1, 5));
		System.out.println("sum of Cubes between 1 and 5 = " + obj.sumOfCubes(1, 5));
		System.out.println("sum of Factorials between 1 and 5 = " + obj.sumOfFactorials(1, 5));
	}
	
	public int sumOverF(Function<Integer, Integer> f, int a, int b) {
		if (a > b) {
			return 0;
		} else {
			return f.apply(a) + sumOverF(f, a + 1, b);
		}
	}

	public int sumOfNumbers(int a, int b) {
		return sumOverF(x -> x, a, b);
	}

	public int sumOfCubes(int a, int b) {
		return sumOverF(x -> x*x*x, a, b);
	}

	public int sumOfFactorials(int a, int b) {
		return sumOverF(x -> fact(x), a, b);
	}

	public int fact(int a) {
		if (a <= 1) {
			return a;
		} else {
			return a * fact(a - 1);
		}
	}


}
