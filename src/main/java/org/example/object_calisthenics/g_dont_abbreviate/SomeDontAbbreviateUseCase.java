package org.example.object_calisthenics.g_dont_abbreviate;

import java.util.Set;

public class SomeDontAbbreviateUseCase {

	private final VeterinarianRepository veterinarianRepository;

	public SomeDontAbbreviateUseCase(VeterinarianRepository veterinarianRepository) {
		this.veterinarianRepository = veterinarianRepository;
	}

	public Set<String> retrievePetsKindsForVet(String vetName) {
		Veterinarian veterinarian = veterinarianRepository.findVet(vetName);
		return veterinarian.retrievePetsKinds();
	}

}
