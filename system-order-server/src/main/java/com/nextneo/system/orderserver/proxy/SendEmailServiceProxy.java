package com.nextneo.system.orderserver.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "nextneo-system-send-email")
@FeignClient(name = "nextneo-system-zuul-api-gateway-server")
@RibbonClient(name = "nextneo-system-send-email")
public interface SendEmailServiceProxy {
	
	//@RequestMapping(method=RequestMethod.GET, path="/send-email")
	@RequestMapping(method=RequestMethod.GET, path="/nextneo-system-send-email/send-email")
	public Boolean sendEmail();

}
