package org.example.object_calisthenics.d_wrap_primitive.step2;

import org.example.object_calisthenics.d_wrap_primitive.EmailAddress;
import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.regex.Pattern;

@Builder
@EqualsAndHashCode
public class Email {

	public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private EmailAddress recipientEmailAddress;
	private EmailAddress senderEmailAddress;
	private Subject subject;
	private Body body;

	public Email(EmailAddress recipientEmailAddress, EmailAddress senderEmailAddress, Subject subject, Body body) {
		this.recipientEmailAddress = recipientEmailAddress;
		this.senderEmailAddress = senderEmailAddress;
		this.subject = subject;
		this.body = body;
	}

}
