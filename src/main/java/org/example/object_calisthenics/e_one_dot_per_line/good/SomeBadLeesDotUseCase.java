package org.example.object_calisthenics.e_one_dot_per_line.good;


import java.util.Set;

public class SomeBadLeesDotUseCase {

	private final VetRepository vetRepository;

	public SomeBadLeesDotUseCase(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	public Set<String> retrievePetsKindsForVet(String vetName) {
		Vet veterinarian = vetRepository.findVet(vetName);
		return veterinarian.retrievePetsKinds();
	}

}
