package org.example.object_calisthenics.c_2_or_3_max_var.other_example;

public class Client {
	private String firstName;
	private String lastName;
	private String street;
	private String city;

	public String buildFullName() {
		return firstName + " " + lastName;
	}

	public String buildAddress() {
		return street + " " + city;
	}
}
