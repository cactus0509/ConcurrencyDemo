package test;

import java.util.HashSet;

public class MyHashSet {
	public static void main(String args[]) {
		HashSet set = new HashSet();
		set.add("a");
		set.add("a");
		set.add("b");
		System.out.println(set.toString());
	}
}
