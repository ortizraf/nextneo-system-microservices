package com.nextneo.system.sendemail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextneo.system.sendemail.dto.wrapper.SendEmailWrapper;
import com.nextneo.system.sendemail.service.SendEmailService;
import com.nextneo.system.sendemail.utils.path.ResourcePath;


@RestController
public class SendEmailController {
	
	Logger logger = LoggerFactory.getLogger(SendEmailController.class);
	
	@Autowired
	private SendEmailService service;
	
	@RequestMapping(method = RequestMethod.GET, path = ResourcePath.SendEmail.TEST)
	public Boolean test() {
		logger.info("send-email-test");
		
		return true;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = ResourcePath.SendEmail.SEND_EMAIL)
	public void sendEmail(@RequestBody SendEmailWrapper sendEmailWrapper) {
		logger.info("send-email");
		
		service.sendEmail(sendEmailWrapper);

	}

}
