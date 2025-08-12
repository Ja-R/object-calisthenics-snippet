package org.example.object_calisthenics.f_wrap_collection;

import org.example.object_calisthenics.c_2_or_3_max_var.other_example.Address;
import org.example.object_calisthenics.c_2_or_3_max_var.other_example.Name;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class Person {

	private final Name name;
	private final Address address;
	private final Pets pets;

	public List<String> petsKinds() {
		return pets.petsKinds();
	}

}
