package org.example.object_calisthenics.d_wrap_primitive;

import org.example.object_calisthenics.EmailSender;

public class SendEmailWrapPrimitiveUseCase {

	private final EmailSender emailSender;

	public SendEmailWrapPrimitiveUseCase(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(Email email) {
		emailSender.sendEmail(email);
	}

}
