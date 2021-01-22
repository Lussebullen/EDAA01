package test;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Integer> nbrs = new LinkedHashSet<>();
		for (int i = 0; i < 100; i += 10) {
			nbrs.add(i);
			nbrs.add(i); // notera: talet läggs till två gånger
		}
		for (int a : nbrs) {
		System.out.println(a);
		}
	}

}
