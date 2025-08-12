package org.example.object_calisthenics.c_2_or_3_max_var;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

@Builder
@EqualsAndHashCode
public class Email {

	public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private final String recipientEmailAddress;
	private final String senderEmailAddress;
	private final String subject;
	private final String body;

	public Email(String recipientEmailAddress, String senderEmailAddress, String subject, String body) {
		this.validateEmailAddress(recipientEmailAddress, "recipient");
		this.validateEmailAddress(senderEmailAddress, "sender");
		this.validateBody(body);

		this.recipientEmailAddress = recipientEmailAddress;
		this.senderEmailAddress = senderEmailAddress;
		this.subject = subject;
		this.body = body;
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
