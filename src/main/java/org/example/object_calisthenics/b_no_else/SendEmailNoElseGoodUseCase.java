package org.example.object_calisthenics.b_no_else;

import org.example.object_calisthenics.EmailSender;
import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

public class SendEmailNoElseGoodUseCase {

	private static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private final EmailSender emailSender;

	public SendEmailNoElseGoodUseCase(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(String recipientEmailAddress, String senderEmailAddress, String subject, String body) {
		validateEmailAddress(recipientEmailAddress, "recipient");
		validateEmailAddress(senderEmailAddress, "sender");
		validateBody(body);

		emailSender.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body);

	}

	private void validateEmailAddress(String emailAddress, String type) {
		if (Strings.isBlank(emailAddress)) {
			throw new IllegalArgumentException("Email address of %s is required".formatted(type));
		}

		if (!EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches()) {
			throw new IllegalArgumentException("Email address of %s is invalid".formatted(type));
		}
	}

	private void validateBody(String body) {
		if (Strings.isBlank(body)) {
			throw new IllegalArgumentException("Body is required");
		}
	}

}
