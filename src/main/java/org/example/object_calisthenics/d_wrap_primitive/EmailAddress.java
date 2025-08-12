package org.example.object_calisthenics.d_wrap_primitive;

import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

@EqualsAndHashCode
public class EmailAddress {
	private static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private final String email;

	private EmailAddress(String email) {
		this.email = email;
	}

	public static EmailAddress forRecipient(String email) {
		validate(email, "recipient");
		return new EmailAddress(email);
	}

	public static EmailAddress forSender(String email) {
		validate(email, "sender");
		return new EmailAddress(email);
	}

	private static void validate(String emailAddress, String type) {
		doesExist(emailAddress, type);
		isValid(emailAddress, type);
	}

	private static void isValid(String emailAddress, String type) {
		if (!EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches()) {
			throw new IllegalArgumentException("Email address of %s is invalid".formatted(type));
		}
	}

	private static void doesExist(String emailAddress, String type) {
		if (Strings.isBlank(emailAddress)) {
			throw new IllegalArgumentException("Email address of %s is required".formatted(type));
		}
	}

}
