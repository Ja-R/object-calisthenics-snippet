package org.example.object_calisthenics.c_2_or_3_max_var;

import org.example.object_calisthenics.EmailSender;

public class SendEmailMinVarStep1UseCase {

	private final EmailSender emailSender;

	public SendEmailMinVarStep1UseCase(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(Email email) {
		emailSender.sendEmail(email);
	}

}
