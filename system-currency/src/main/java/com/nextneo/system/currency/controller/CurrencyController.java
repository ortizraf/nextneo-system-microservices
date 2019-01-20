package com.nextneo.system.currency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nextneo.system.currency.client.SendEmailClient;
import com.nextneo.system.currency.service.CurrencyService;
import com.nextneo.system.currency.utils.path.ResourcePath;

@RestController
public class CurrencyController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private SendEmailClient client;
	
	@Autowired
	private CurrencyService service;
	
    @RequestMapping(method = RequestMethod.GET, path = ResourcePath.Currency.CURRENCY_EXCHANGE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String currencyExchange(@PathVariable String from, @PathVariable String to) {
    	logger.info("currencyExchange");
    	
    	String response = null;
    	try {
			response = service.currencyExchange(from, to);
		} catch (Exception e) {
			e.getMessage();
		}
    	logger.info(response);
    	
    	client.sendEmail(service.getSendEmailWrapper(response));
		
		return response;
	}
  
    @RequestMapping(method = RequestMethod.GET, path = ResourcePath.Currency.TEST)
	public Boolean test() {
    	logger.info("test");

		Boolean response = client.test();
		
		return response;
	}
    
    @RequestMapping(method=RequestMethod.GET, path="/fault-test")
    @HystrixCommand(fallbackMethod="fault")
   	public Boolean faultTest() {
       	logger.info("faultTest");

   		throw new RuntimeException();
   	}
    
    public Boolean fault() {
    	return false;
    }
}