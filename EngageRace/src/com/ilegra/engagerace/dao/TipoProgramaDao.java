package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.entity.TipoPrograma;

@Repository
public class TipoProgramaDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<TipoPrograma> listaTipoPrograma() {
  	    Criteria c = getCurrentSession().createCriteria(TipoPrograma.class);
  		return c.list();
	}
}