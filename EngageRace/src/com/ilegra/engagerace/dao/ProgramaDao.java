package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.entity.Programa;

@Repository
public class ProgramaDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void salvaPrograma(Programa programa) {
        getCurrentSession().save(programa);
	}

	public void editaPrograma(Programa programa) {
        getCurrentSession().update(programa);
	}

	public void excluiPrograma(Programa programa) {
        getCurrentSession().delete(programa);
	}

	@SuppressWarnings("unchecked")
	public List<Programa> pesquisaPrograma() {
  	    Criteria c = getCurrentSession().createCriteria(Programa.class);
  	    c.addOrder(Order.asc("nomePrograma"));
  	    return c.list();
	}
}