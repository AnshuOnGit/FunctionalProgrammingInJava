package org.simple.lifeiseasy;

public class HigherOrderFunctions {

	public static void main(String[] args) {
		HigherOrderFunctions obj = new HigherOrderFunctions();
		System.out.println("sum of Numbers between 1 and 5 = " + obj.sumOfNumbers(1, 5));
		System.out.println("sum of Cubes between 1 and 5 = " + obj.sumOfCubes(1, 5));
		System.out.println("sum of Factorials between 1 and 5 = " + obj.sumOfFactorials(1, 5));
	}

	public int sumOfNumbers(int a, int b) {
		if (a > b) {
			return 0;
		} else {
			return a + sumOfNumbers(a + 1, b);
		}
	}

	public int sumOfCubes(int a, int b) {
		if (a > b) {
			return 0;
		} else {
			return a * a * a + sumOfCubes(a + 1, b);
		}
	}

	public int sumOfFactorials(int a, int b) {
		if (a > b) {
			return 0;
		} else {
			return fact(a) + sumOfFactorials(a + 1, b);
		}
	}

	public int fact(int a) {
		if (a <= 1) {
			return a;
		} else {
			return a * fact(a - 1);
		}
	}

}
