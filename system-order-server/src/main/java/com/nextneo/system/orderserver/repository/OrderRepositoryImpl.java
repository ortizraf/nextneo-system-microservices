package com.nextneo.system.orderserver.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.nextneo.system.orderserver.model.Ordr;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ordr findId(Long id) {
		
		TypedQuery<Ordr> query = em.createQuery("SELECT new Ordr(o) from Ordr o where o.id = :pId ", Ordr.class);
		query.setParameter("pId", id);
		
		Ordr order = null;
		try {
			order = query.getSingleResult();
		} catch (NoResultException nre) {
			/* NoResultException */
		}

		return order;
	}
	
}
