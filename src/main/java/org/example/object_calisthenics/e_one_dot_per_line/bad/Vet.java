package org.example.object_calisthenics.e_one_dot_per_line.bad;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Vet {
	private final String name;
	private final List<Client> petOwners;
}
