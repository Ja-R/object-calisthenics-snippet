package org.example.object_calisthenics.e_one_dot_per_line.good;

import org.example.object_calisthenics.c_2_or_3_max_var.other_example.Address;
import org.example.object_calisthenics.c_2_or_3_max_var.other_example.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class SomeBadLeesDotUseCaseTest {

	@Mock
	private VetRepository vetRepository;

	private SomeBadLeesDotUseCase useCase;

	@BeforeEach
	void setUp() {
		useCase = new SomeBadLeesDotUseCase(vetRepository);
	}

	private final Client client1 = new Client(
			new Name("Firstname1", "Surname1"),
			new Address("Street1", "City1"),
			List.of(new Pet("Rex", "Dog"), new Pet("Billy", "Cat"))
	);
	private final Client client2 = new Client(
			new Name("Firstname2", "Surname2"),
			new Address("Street2", "City2"),
			List.of(new Pet("Coucou", "Bird"), new Pet("Garou", "Cat"), new Pet("Mickey", "Mousse"))
	);
	private final Client client3 = new Client(
			new Name("Firstname3", "Surname3"),
			new Address("Street3", "City3"),
			List.of(new Pet("Flaky", "Snake"))
	);
	private final Vet vet = new Vet("Little", List.of(client1, client2, client3));

	@Test
	void name() {
		Mockito.when(vetRepository.findVet(vet.getName())).thenReturn(vet);


		Set<String> result = useCase.retrievePetsKindsForVet(vet.getName());

		Assertions.assertThat(result).contains("Dog", "Cat", "Bird", "Mousse", "Snake");
	}


}
