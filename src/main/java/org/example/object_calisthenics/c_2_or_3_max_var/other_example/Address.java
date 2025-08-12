package org.example.object_calisthenics.c_2_or_3_max_var.other_example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Address {
	private final String street;
	private final String city;

	public String buildAddress() {
		return street + " " + city;
	}
}
