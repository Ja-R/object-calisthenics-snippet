package org.example.object_calisthenics.e_one_dot_per_line.bad;

import java.util.Set;
import java.util.stream.Collectors;

public class SomeBadTooManyDotUseCase {

	private final VetRepository vetRepository;

	public SomeBadTooManyDotUseCase(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	public Set<String> retrievePetsKindsForVet(String vetName) {
		Vet veterinarian = vetRepository.findVet(vetName);

		return veterinarian.getPetOwners().stream().flatMap(person -> person.getPets().stream()).map(Pet::getKind).collect(Collectors.toSet());
	}

}
