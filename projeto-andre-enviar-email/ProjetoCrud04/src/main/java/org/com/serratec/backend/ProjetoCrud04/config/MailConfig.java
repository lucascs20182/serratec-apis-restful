package org.com.serratec.backend.ProjetoCrud04.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	JavaMailSender javaMail;
	
	public String sendMail(String para, String assunto, String texto) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("rubberducks20212@gmail.com");
		mail.setTo(para);
		mail.setSubject(assunto);
		mail.setText(texto);
		javaMail.send(mail);
		return "E-mail enviado com sucesso";
//		MimeMessage mail = javaMail.createMimeMessage();
//		mail.setSubject(assunto);
//		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
//		helper.setFrom("andrecaetanobackend@gmail.com");
//		helper.setTo(para);
//		helper.setText(texto,true);
//		javaMail.send(mail);
//		return "E-mail enviado com sucesso";
	}
}
