package com.nextneo.system.orderserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextneo.system.orderserver.model.Ordr;
import com.nextneo.system.orderserver.proxy.SendEmailServiceProxy;
import com.nextneo.system.orderserver.service.OrderService;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private SendEmailServiceProxy proxy;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Ordr> save(@RequestBody  Ordr order){
        return ResponseEntity.ok(orderService.save(order));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ordr> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Ordr>> findAll(){
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @RequestMapping(method=RequestMethod.GET, path="/test")
	public Boolean test() {
    	logger.info("test");

		Boolean response = proxy.sendEmail();
		
		return response;
	}
}