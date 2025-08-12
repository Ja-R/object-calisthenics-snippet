package org.example.object_calisthenics.b_no_else;

import org.example.object_calisthenics.EmailSender;

import java.util.regex.Pattern;

public class SendEmailNoElseUseCase {

	public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private final EmailSender emailSender;

	public SendEmailNoElseUseCase(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(String recipientEmailAddress, String senderEmailAddress, String subject, String body) {

		if (recipientEmailAddress == null || recipientEmailAddress.isEmpty()) {
			throw new IllegalArgumentException("Email address of recipient is required");
		} else if (!EMAIL_ADDRESS_REGEX.matcher(recipientEmailAddress).matches()) {
			throw new IllegalArgumentException("Email address of recipient is invalid");
		} else if (senderEmailAddress == null || senderEmailAddress.isEmpty()) {
			throw new IllegalArgumentException("Email address of sender is required");
		} else if (!EMAIL_ADDRESS_REGEX.matcher(senderEmailAddress).matches()) {
			throw new IllegalArgumentException("Email address of sender is invalid");
		} else if (body == null || body.isEmpty()) {
			throw new IllegalArgumentException("Body is required");
		} else {
			emailSender.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body);
		}

	}

}
