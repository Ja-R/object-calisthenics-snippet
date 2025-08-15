package org.example.object_calisthenics.d_wrap_primitive;

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
class SendEmailWrapPrimitiveUseCaseTest {


	@Mock
	private EmailSender emailSender;

	private SendEmailWrapPrimitiveUseCase sendEmailUseCase;

	@BeforeEach
	void setUp() {
		sendEmailUseCase = new SendEmailWrapPrimitiveUseCase(emailSender);
	}

	@Test
	void send_email() {
		Email email = Email.builder()
				.recipientEmailAddress(EmailAddress.forRecipient("recipient@test.be"))
				.senderEmailAddress(EmailAddress.forSender("sender@test.be"))
				.subject(new Subject("subject"))
				.body(new Body("body"))
				.build();

		sendEmailUseCase.sendEmail(email);

		Mockito.verify(emailSender)
				.sendEmail(email);
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalidEmailAddress", "invalidEmailAddress@"})
	void fails_when_recipient_email_address_is_invalid(String recipientEmailAddress) {
		Assertions.assertThatThrownBy(() -> Email.builder()
						.recipientEmailAddress(EmailAddress.forRecipient(recipientEmailAddress))
						.senderEmailAddress(EmailAddress.forSender("sender@test.be"))
						.subject(new Subject("subject"))
						.body(new Body("body"))
						.build())
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of recipient is invalid");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void fails_when_recipient_email_address_is_not_given(String recipientEmailAddress) {
		Assertions.assertThatThrownBy(() -> Email.builder()
						.recipientEmailAddress(EmailAddress.forRecipient(recipientEmailAddress))
						.senderEmailAddress(EmailAddress.forSender("sender@test.be"))
						.subject(new Subject("subject"))
						.body(new Body("body"))
						.build())
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of recipient is required");
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalidEmailAddress", "invalidEmailAddress@"})
	void fails_when_sender_email_address_is_invalid(String senderEmailAddress) {

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(Email.builder()
						.recipientEmailAddress(EmailAddress.forRecipient("recipient@test.be"))
						.senderEmailAddress(EmailAddress.forSender(senderEmailAddress))
						.subject(new Subject("subject"))
						.body(new Body("body"))
						.build()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of sender is invalid");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void fails_when_sender_email_address_is_not_given(String senderEmailAddress) {

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(Email.builder()
						.recipientEmailAddress(EmailAddress.forRecipient("recipient@test.be"))
						.senderEmailAddress(EmailAddress.forSender(senderEmailAddress))
						.subject(new Subject("subject"))
						.body(new Body("body"))
						.build()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of sender is required");
	}

	@Test
	void fails_when_sender_body_is_invalid() {

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(Email.builder()
						.recipientEmailAddress(EmailAddress.forRecipient("recipient@test.be"))
						.senderEmailAddress(EmailAddress.forSender("sender@test.be"))
						.subject(new Subject("subject"))
						.body(new Body(null))
						.build()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Body is required");
	}

}
