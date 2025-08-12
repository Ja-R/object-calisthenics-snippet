package org.example.object_calisthenics.a_one_level_indentation;

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
class SendEmailOneLevelIndentUseCaseTest {

	@Mock
	private EmailSender emailSender;

	private SendEmailOneLevelIndentUseCase sendEmailUseCase;

	@BeforeEach
	void setUp() {
		sendEmailUseCase = new SendEmailOneLevelIndentUseCase(emailSender);
	}

	@Test
	void send_email() {
		String recipientEmailAddress = "recipient@test.be";
		String senderEmailAddress = "sender@test.be";
		String subject = "subject";
		String body = "body";

		sendEmailUseCase.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body);

		Mockito.verify(emailSender)
				.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body);
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalidEmailAddress", "invalidEmailAddress@"})
	void fails_when_recipient_email_address_is_invalid(String recipientEmailAddress) {
		String senderEmailAddress = "sender@test.be";
		String subject = "subject";
		String body = "body";

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of recipient is invalid");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void fails_when_recipient_email_address_is_not_given(String recipientEmailAddress) {
		String senderEmailAddress = "sender@test.be";
		String subject = "subject";
		String body = "body";

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of recipient is required");
	}

	@ParameterizedTest
	@ValueSource(strings = {"invalidEmailAddress", "invalidEmailAddress@"})
	void fails_when_sender_email_address_is_invalid(String senderEmailAddress) {
		String recipientEmailAddress = "recipient@test.be";
		String subject = "subject";
		String body = "body";

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of sender is invalid");
	}

	@ParameterizedTest
	@NullAndEmptySource
	void fails_when_sender_email_address_is_not_given(String senderEmailAddress) {
		String recipientEmailAddress = "recipient@test.be";
		String subject = "subject";
		String body = "body";

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email address of sender is required");
	}

	@Test
	void fails_when_sender_body_is_invalid() {
		String recipientEmailAddress = "recipient@test.be";
		String senderEmailAddress = "sender@test.be";
		String subject = "subject";
		String body = "";

		Assertions.assertThatThrownBy(() -> sendEmailUseCase.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Body is required");
	}
}
