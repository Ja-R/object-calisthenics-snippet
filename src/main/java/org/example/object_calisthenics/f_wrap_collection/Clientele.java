package org.example.object_calisthenics.f_wrap_collection;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Clientele {
	private final List<Person> clientele;

	private Clientele(List<Person> clientele) {
		this.clientele = clientele;
	}

	public static Clientele of(List<Person> clientele) {
		return new Clientele(clientele);
	}

	public Set<String> retrievePetsKinds() {
		return this.clientele
				.stream()
				.map(Person::petsKinds)
				.flatMap(List::stream)
				.collect(Collectors.toSet());
	}
}

