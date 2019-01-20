package com.nextneo.system.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextneo.system.authserver.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}
