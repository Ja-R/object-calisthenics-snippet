package org.example.object_calisthenics.f_wrap_collection;

import java.util.Set;

public class SomeWrapCollectionUseCase {

	private final VetRepository vetRepository;

	public SomeWrapCollectionUseCase(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	public Set<String> retrievePetsKindsForVet(String vetName) {
		Vet veterinarian = vetRepository.findVet(vetName);
		return veterinarian.retrievePetsKinds();
	}

}
