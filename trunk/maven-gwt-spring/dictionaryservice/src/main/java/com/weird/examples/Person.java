package com.weird.examples;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Person {
	private String firstName;
	private String surname;

	public Person(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals getting evaluated");
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Person rhs = (Person) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(firstName, rhs.firstName).append(surname, rhs.surname)
				.isEquals();
	}

	public int hashCode() {
		System.out.println("Hash getting calculated");
		int code = surname.hashCode();
		code = 31 * code + firstName.hashCode();
		return code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
