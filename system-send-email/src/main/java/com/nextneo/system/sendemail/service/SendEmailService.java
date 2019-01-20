package com.nextneo.system.sendemail.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nextneo.system.sendemail.dto.wrapper.SendEmailWrapper;

@Service
public class SendEmailService {
	
	Logger logger = LoggerFactory.getLogger(SendEmailService.class);
	
	public void sendEmail(SendEmailWrapper sendEmailWrapper) {
		
		send(sendEmailWrapper);
		
	}
	
	private Properties getProperties(SendEmailWrapper sendEmailWrapper) {
		Properties props = new Properties();
	    props.put("mail.smtp.host", (sendEmailWrapper.getProperties().containsKey("mail.smtp.host") ? sendEmailWrapper.getProperties().get("mail.smtp.host") : "smtp.gmail.com"));
	    props.put("mail.smtp.socketFactory.port", (sendEmailWrapper.getProperties().containsKey("mail.smtp.port") ? sendEmailWrapper.getProperties().get("mail.smtp.port") : "465"));
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    if (sendEmailWrapper.getProperties().containsKey("mail.smtp.starttls.enable")) {
	    	props.put("mail.smtp.starttls.enable", sendEmailWrapper.getProperties().get("mail.smtp.starttls.enable"));
	    }
	    if (sendEmailWrapper.getProperties().containsKey("mail.smtp.ssl.enable")) {
	    	props.put("mail.smtp.ssl.enable", sendEmailWrapper.getProperties().get("mail.smtp.ssl.enable"));
	    }
	    props.put("mail.smtp.auth", (sendEmailWrapper.getProperties().containsKey("mail.smtp.auth") ? sendEmailWrapper.getProperties().get("mail.smtp.auth") : "true"));
	    props.put("mail.smtp.port", (sendEmailWrapper.getProperties().containsKey("mail.smtp.port") ? sendEmailWrapper.getProperties().get("mail.smtp.port") : "465"));
	    props.put("mail.debug", "true");
	    
	    return props;
	}
	
	
	private void send(SendEmailWrapper sendEmailWrapper) {

		if (sendEmailWrapper.getProperties() == null) {
			throw new RuntimeException("no properties");
		}
		Properties 	props = getProperties(sendEmailWrapper);
	
	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(sendEmailWrapper.getLogin(), sendEmailWrapper.getPassword());
			}
		});
	
	    try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(sendEmailWrapper.getFrom()));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(sendEmailWrapper.getTo()));
	        message.setSubject(sendEmailWrapper.getSubject());
	        message.setText(sendEmailWrapper.getContent());
	
	        Transport.send(message);
	        
	        logger.info("Done");
	        logger.info("sent email from "+sendEmailWrapper.getFrom()+" to "+sendEmailWrapper.getTo()+" with content "+sendEmailWrapper.getContent());
	
	    } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    } catch (Exception e) {
	    	e.getMessage();
		}
	}

}
