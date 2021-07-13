package org.simple.lifeiseasy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

public class MapAndFlatMap {

	/*
	 * FlatMap is defined as (M[A], A => M[B]) => M[B]
	 * 
	 * Map is defined as M[A] => M[B]
	 * 
	 */

	@Test
	public void test() {
		assertEquals(Optional.of(Optional.of("STRING")), 
				Optional.of("string")
				.map(s -> Optional.of(s.toUpperCase())));
		
		assertEquals(Optional.of("STRING"), 
				  Optional.of("string")
				  .flatMap(s -> Optional.of(s.toUpperCase())));
	}

	/*public static void main(String[] args) {

		List<String> names = Arrays.asList("Hello", "how", "are", "you", "?");

		// M--> List A-->String B-->Integer
		names.stream().map(x -> x.length()).collect(Collectors.toList()).forEach(x -> System.out.println(x));

		// M--> List A--> Character B-->Boolean
		// names.stream().flatMap(x -> x.chars()).collect(Collectors.toList())
		// .forEach(x -> System.out.println(x));

	}*/

}
