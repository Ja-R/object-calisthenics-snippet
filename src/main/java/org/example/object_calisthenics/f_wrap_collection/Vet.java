package org.example.object_calisthenics.f_wrap_collection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Vet {
	private final String name;
	private final Clientele petOwners;

	public Set<String> retrievePetsKinds() {
		return petOwners.retrievePetsKinds();
	}
}
