package com.nextneo.system.currency.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.client.HttpStatusCodeException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HttpClientErrorExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(HttpClientErrorExceptionHandler.class);

	@Autowired
	private ObjectMapper objectMapper;

	public void handle(HttpStatusCodeException exception) throws BusinessException, Exception {

		if (HttpStatus.BAD_REQUEST.equals(exception.getStatusCode())) {
			
			logger.error(exception.getResponseBodyAsString());
			

		} else if (HttpStatus.PRECONDITION_FAILED.equals(exception.getStatusCode())) {
			
			logger.error(exception.getResponseBodyAsString());
			
		} else if (HttpStatus.UNPROCESSABLE_ENTITY.equals(exception.getStatusCode())) {
			
			logger.error(exception.getResponseBodyAsString());
			
			Errors errors = objectMapper.readValue(exception.getResponseBodyAsString(), Errors.class);

			throw new BusinessException("", errors);

		} else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(exception.getStatusCode())) {
			
			logger.error(exception.getResponseBodyAsString());

		}

		throw exception;
	}

}