package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ilegra.engagerace.entity.Programa;
import com.ilegra.engagerace.util.HibernateUtil;

public class ProgramaDao {
	
	public void salvaPrograma(Programa programa) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(programa);
        session.getTransaction().commit();		
	}

	public void editaPrograma(Programa programa) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();
        session.update(programa);
        session.getTransaction().commit();
	}

	public void excluiPrograma(Programa programa) {
        Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(programa);
        session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Programa> pesquisaPrograma() {
		List<Programa> programas = null;
  		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(Programa.class);
  	    
  	    programas = c.list();
  	    session.getTransaction().commit();
  		return programas;
	}
}