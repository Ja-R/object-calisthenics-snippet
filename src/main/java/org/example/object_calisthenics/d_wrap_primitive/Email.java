package org.example.object_calisthenics.d_wrap_primitive;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;

@Builder
@EqualsAndHashCode
public class Email {

	private final EmailAddress recipientEmailAddress;
	private final EmailAddress senderEmailAddress;
	private final String subject;
	private final String body;

	public Email(EmailAddress recipientEmailAddress, EmailAddress senderEmailAddress, String subject, String body) {
		this.validateBody(body);
		this.recipientEmailAddress = recipientEmailAddress;
		this.senderEmailAddress = senderEmailAddress;
		this.subject = subject;
		this.body = body;
	}

	private void validateBody(String body) {
		if (Strings.isBlank(body)) {
			throw new IllegalArgumentException("Body is required");
		}
	}

}
