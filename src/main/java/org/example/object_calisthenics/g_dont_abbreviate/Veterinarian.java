package org.example.object_calisthenics.g_dont_abbreviate;

import org.example.object_calisthenics.f_wrap_collection.Clientele;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Veterinarian {
	private final String name;
	private final Clientele petOwners;

	public Set<String> retrievePetsKinds() {
		return petOwners.retrievePetsKinds();
	}
}
