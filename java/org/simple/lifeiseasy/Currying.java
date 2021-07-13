package org.simple.lifeiseasy;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Currying {
	public static void main(String[] args) {
		Currying obj = new Currying();
		System.out.println("sum of Numbers between 1 and 5 = " + obj.sumOfNumbers().apply(1, 5));
		System.out.println("sum of Cubes between 1 and 5 = " + obj.sumOfCubes().apply(1, 5));
		System.out.println("sum of Factorials between 1 and 5 = " + obj.sumOfFactorials().apply(1, 5));
	}

	public BiFunction<Integer, Integer, Integer> sumOverF(Function<Integer, Integer> f) {
		return (a, b) -> {
			if (a > b) {
				return 0;
			} else {
				return f.apply(a) + sumOverF(f).apply(a + Integer.valueOf(1), b);
			}
		};
	}

	public BiFunction<Integer, Integer, Integer> sumOfNumbers() {
		return sumOverF(x -> x);
	}

	public BiFunction<Integer, Integer, Integer> sumOfCubes() {
		return sumOverF(x -> x * x * x);
	}

	public BiFunction<Integer, Integer, Integer> sumOfFactorials() {
		return sumOverF(x -> fact(x));
	}

	public int fact(int a) {
		if (a <= 1) {
			return a;
		} else {
			return a * fact(a - 1);
		}
	}

}
