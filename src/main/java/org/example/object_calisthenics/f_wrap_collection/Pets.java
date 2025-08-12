package org.example.object_calisthenics.f_wrap_collection;

import java.util.List;

public class Pets {
	private List<Pet> pets;

	public Pets(List<Pet> pets) {
		this.pets = pets;
	}

	public static Pets of(List<Pet> pets) {
		return new Pets(pets);
	}

	public List<String> petsKinds() {
		return this.pets
				.stream()
				.map(Pet::getKind)
				.toList();
	}
}
