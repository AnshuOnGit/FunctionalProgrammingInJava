package org.simple.lifeiseasy.monads;

import java.util.HashMap;
import java.util.Map;


public class TryApp {

	public static void main(String[] args) {
		final int x = 2;
		int result = Try.ofFailable(() -> 20 / x).orElse(5);
		System.out.println(result);

		Map<String, Integer> cache = new HashMap<>();
		cache.put("1", 1);
		cache.put("2", 2);

		Try<Integer> resultMonad = Try.ofFailable(() -> 20 / cache.get("2"))
				.orElseTry(() -> {
										System.out.println("Cache failed...");
										return 20 / Integer.valueOf("3");
								  }
				);
		
		resultMonad
		.onSuccess((val) -> System.out.println("after calculation result was =" + val))
		.onFailure((e) -> System.out.println("error was =" + e.getMessage()));

	}

}
