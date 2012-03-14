package com.weird.examples;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		System.out.println("We are introducing Joe Bloggs");
		Person joe = new Person("Joe", "Bloggs");
		Set<Person> people = new HashSet<Person>();
		people.add(joe);

		System.out.println("Is Joe present in the people set : " + people.contains(joe)); // this works
		System.out.println("Could Joe's clone be present in the people set : " + people.contains(new Person("Joe", "Bloggs"))); // this works

		System.out.println("Joe got married and now is Joe Smith");
		joe.setSurname("Smith");

		System.out.println("Joe Bloggs clone is not present in the directory now is that true? : " + !people.contains(new Person("Joe", "Bloggs"))); // this works
		System.out.println("Joe Smith's clone is present in the directory now is that true? : " + people.contains(new Person("Joe", "Smith"))); // this fails!!!
		System.out.println("Really is the same Joe present : " + people.contains(joe)); // this fails!!!

		boolean found = false;
		for (Person person : people) {
			if (person.equals(joe)) {
				found = true;
				break;
			}
		}
		System.out.println("Wait i will check myself and Joe Smith is present ? " + found);
	}
}
