package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ilegra.engagerace.entity.Administrador;
import com.ilegra.engagerace.util.HibernateUtil;

public class AdministradorDao {
	
	static AdministradorDao administradorDao = new AdministradorDao();
	
	public void salvaAdministrador(Administrador administrador) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(administrador);
        session.getTransaction().commit();	
        session.close();
	}

	public void editaAdministrador(Administrador administrador) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();
        session.update(administrador);
        session.getTransaction().commit();
        session.close();
	}

	public void excluiAdministrador(Administrador administrador) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(administrador);
        session.getTransaction().commit();		
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> pesquisaAdministrador() {
		List<Administrador> administradores = null;
  		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(Administrador.class);
  	    
  	    administradores = c.list();
  	    session.close();  		  		
  		return administradores;
	}
}