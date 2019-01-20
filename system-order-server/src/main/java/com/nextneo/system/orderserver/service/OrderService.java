package com.nextneo.system.orderserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.nextneo.system.orderserver.model.Ordr;
import com.nextneo.system.orderserver.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Ordr save(@Validated Ordr ordr) {
        return orderRepository.save(ordr);
    }

    public Ordr findById(Long id){
        return orderRepository.findId(id);
    }

    public Iterable<Ordr> findAll(){
        return orderRepository.findAll();
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
