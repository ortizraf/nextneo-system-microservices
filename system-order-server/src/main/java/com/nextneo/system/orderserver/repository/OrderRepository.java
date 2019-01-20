package com.nextneo.system.orderserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextneo.system.orderserver.model.Ordr;

public interface OrderRepository extends JpaRepository<Ordr, Long>, OrderRepositoryCustom {

}
