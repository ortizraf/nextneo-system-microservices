package com.nextneo.system.currency.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextneo.system.currency.dto.wrapper.SendEmailWrapper;
import com.nextneo.system.currency.utils.path.ResourcePath;

//FeignClient(name = ResourcePath.SERVICE_SEND_EMAIL)
@FeignClient(name = ResourcePath.SERVICE_API_GATEWAY)
@RibbonClient(name = ResourcePath.SERVICE_SEND_EMAIL)
public interface SendEmailClient {
	
	//@RequestMapping(method=RequestMethod.GET, path= ResourcePath.SendEmail.TEST)
	@RequestMapping(method=RequestMethod.GET, path="/"+ResourcePath.SERVICE_SEND_EMAIL+ResourcePath.SendEmail.TEST)
	public Boolean test();
	
	@RequestMapping(method=RequestMethod.POST, path="/"+ResourcePath.SERVICE_SEND_EMAIL+ResourcePath.SendEmail.SEND_EMAIL)
	public void sendEmail(@RequestBody SendEmailWrapper sendEmailWrapper);

}
