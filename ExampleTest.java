package br.org.creathus.psi40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExampleTest {
	@Test
	@DisplayName("Should demonstrate a simple assertion")
	void shouldShowSimpleAssertion() {
		Assertions.assertEquals(1, 2);
	}
	
	@Test
	void checkAll() {
		List<Integer> numbers = List.of(2, 3, 4, 5);
		Assertions.assertAll(() -> assertEquals(4, numbers.get(0)),
				() -> assertEquals(3, numbers.get(1)),
				() -> assertEquals(4, numbers.get(2))
				);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"creathus.org.br"})
	void shouldVerifyEmailPattern(String expectedDomain) {
		List<String> emails = List.of("mitozo.marcos@gmail.com", "mitozo.marcos@creathus.org.br");
		Assertions.assertAll(
				() -> assertEquals(expectedDomain, emails.get(0).split("@")[1]),
				() -> assertEquals(expectedDomain, emails.get(1).split("@")[1])
				);
	}
}
