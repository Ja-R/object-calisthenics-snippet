package org.example.object_calisthenics.c_2_or_3_max_var.other_example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Name {
	private final String firstName;
	private final String lastName;

	public String buildFullName() {
		return firstName + " " + lastName;
	}
}
