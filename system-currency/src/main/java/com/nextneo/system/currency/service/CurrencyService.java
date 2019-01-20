package com.nextneo.system.currency.service;

import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.nextneo.system.currency.dto.wrapper.SendEmailWrapper;
import com.nextneo.system.currency.exception.BusinessException;
import com.nextneo.system.currency.exception.HttpClientErrorExceptionHandler;
import com.nextneo.system.currency.utils.path.ResourcePath;

@Service
public class CurrencyService {
	
	Logger logger = LoggerFactory.getLogger(CurrencyService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpClientErrorExceptionHandler httpClientErrorExceptionHandler;
	
	public String currencyExchange(String from, String to) throws BusinessException, Exception {	
		logger.info("currencyExchange");
		
		String currency = null;
		try {
			String url = ResourcePath.API_EXCHANGE_RATES+ResourcePath.ApiExchangeRates.CURRENCY_EXCHANGE;
			
			currency = restTemplate.getForObject(url, String.class, from, to);
		} catch (HttpStatusCodeException e) {			
			httpClientErrorExceptionHandler.handle(e);
		}
		
		return currency;
		
	}

	public SendEmailWrapper getSendEmailWrapper(String response) {
		
		String login = "email@gmail.com";
		String password = "password";
		String from = login;
		String to = from;
		String subject = "Currency Service";
		
		LinkedHashMap<String, String> properties = new LinkedHashMap<>();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");	
		
		SendEmailWrapper sendEmailWrapper = new SendEmailWrapper(properties, login, password, from,
				to, subject, response);

		return sendEmailWrapper;
	}

}
