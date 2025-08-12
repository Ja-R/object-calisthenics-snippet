package org.example.object_calisthenics.e_one_dot_per_line.bad;

import org.example.object_calisthenics.c_2_or_3_max_var.other_example.Address;
import org.example.object_calisthenics.c_2_or_3_max_var.other_example.Name;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class Client {

	private final Name name;
	private final Address address;
	private final List<Pet> pets;

}
