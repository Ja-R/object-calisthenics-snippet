package org.example.object_calisthenics.a_one_level_indentation;

import org.example.object_calisthenics.EmailSender;

import java.util.regex.Pattern;

public class SendEmailOneLevelIndentUseCase {

	public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private final EmailSender emailSender;

	public SendEmailOneLevelIndentUseCase(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(String recipientEmailAddress,
						  String senderEmailAddress,
						  String subject,
						  String body) {

		if (body != null && !body.isEmpty()) {
			if (recipientEmailAddress != null && !recipientEmailAddress.isEmpty()) {
				if (EMAIL_ADDRESS_REGEX.matcher(recipientEmailAddress).matches()) {
					if (senderEmailAddress != null && !senderEmailAddress.isEmpty()) {
						if (EMAIL_ADDRESS_REGEX.matcher(senderEmailAddress).matches()) {
							emailSender.sendEmail(recipientEmailAddress, senderEmailAddress, subject, body);
						} else {
							throw new IllegalArgumentException("Email address of sender is invalid");
						}
					} else {
						throw new IllegalArgumentException("Email address of sender is required");
					}
				} else {
					throw new IllegalArgumentException("Email address of recipient is invalid");
				}
			} else {
				throw new IllegalArgumentException("Email address of recipient is required");
			}
		} else {
			throw new IllegalArgumentException("Body is required");
		}

	}

}
