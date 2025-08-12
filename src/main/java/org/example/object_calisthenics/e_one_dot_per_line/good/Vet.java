package org.example.object_calisthenics.e_one_dot_per_line.good;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class Vet {
	private final String name;
	private final List<Client> petOwners;

	public Set<String> retrievePetsKinds() {
		return petOwners
				.stream()
				.map(Client::petsKinds)
				.flatMap(List::stream)
				.collect(Collectors.toSet());
	}
}
