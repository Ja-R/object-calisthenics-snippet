package org.example.object_calisthenics.c_2_or_3_max_var;

import org.example.object_calisthenics.EmailSender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SendEmailMinVarStep1UseCaseTest {

	@Mock
	private EmailSender emailSender;

	private SendEmailMinVarStep1UseCase sendEmailUseCase;

	@BeforeEach
	void setUp() {
		sendEmailUseCase = new SendEmailMinVarStep1UseCase(emailSender);
	}

	@Test
	void send_email() {
		Email email = Email.builder()
				.recipientEmailAddress("recipient@test.be")
				.senderEmailAddress("sender@test.be")
				.subject("subject")
				.body("body")
				.build();

		sendEmailUseCase.sendEmail(email);

		Mockito.verify(emailSender)
				.sendEmail(email);
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalidEmailAddress", "invalidEmailAddress@"})
	void fails_when_recipient_email_address_is_invalid(String recipientEmailAddress) {
		Assertions.assertThatThrownBy(() -> Email.builder()
				.recipientEmailAddress(recipientEmailAddress)
				.senderEmailAddress("sender@test.be")
				.subject("subject")
				.body("body")
				.build())
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of recipient is invalid");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void fails_when_recipient_email_address_is_not_given(String recipientEmailAddress) {
		Assertions.assertThatThrownBy(() -> Email.builder()
				.recipientEmailAddress(recipientEmailAddress)
				.senderEmailAddress("sender@test.be")
				.subject("subject")
				.body("body")
				.build())
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of recipient is required");
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalidEmailAddress", "invalidEmailAddress@"})
	void fails_when_sender_email_address_is_invalid(String senderEmailAddress) {

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(Email.builder()
						.recipientEmailAddress("recipient@test.be")
						.senderEmailAddress(senderEmailAddress)
						.subject("subject")
						.body("body")
						.build()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of sender is invalid");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void fails_when_sender_email_address_is_not_given(String senderEmailAddress) {

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(Email.builder()
						.recipientEmailAddress("recipient@test.be")
						.senderEmailAddress(senderEmailAddress)
						.subject("subject")
						.body("body")
						.build()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of sender is required");
	}

	@Test
	void fails_when_sender_body_is_invalid() {

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(Email.builder()
						.recipientEmailAddress("recipient@test.be")
						.senderEmailAddress("sender@test.be")
						.subject("subject")
						.build()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Body is required");
	}


}
