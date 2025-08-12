package org.example.object_calisthenics;

import org.example.object_calisthenics.c_2_or_3_max_var.Email;

public interface EmailSender {

	void sendEmail(String recipientEmailAddress, String senderEmailAddress, String subject, String body);

	void sendEmail(Email email);

	void sendEmail(org.example.object_calisthenics.d_wrap_primitive.Email email);

}
