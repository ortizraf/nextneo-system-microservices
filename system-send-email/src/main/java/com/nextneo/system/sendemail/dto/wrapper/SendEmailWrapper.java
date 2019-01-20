package com.nextneo.system.sendemail.dto.wrapper;

import java.util.LinkedHashMap;

public class SendEmailWrapper {
	
	private LinkedHashMap<String, String> properties;
	
	private String login;
	
	private String password;
	
	private String from;
	
	private String to;
	
	private String subject;
	
	private String content;
	

	public LinkedHashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(LinkedHashMap<String, String> properties) {
		this.properties = properties;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	

}
