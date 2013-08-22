package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.entity.Administrador;

@Repository
public class AdministradorDao {

	@Autowired private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public void salvaAdministrador(Administrador administrador) {
		getCurrentSession().save(administrador);
	}

	public void editaAdministrador(Administrador administrador) {
		getCurrentSession().update(administrador);
	}

	public void excluiAdministrador(Administrador administrador) {
		getCurrentSession().delete(administrador);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> pesquisaAdministrador() {
		Criteria c = getCurrentSession().createCriteria(Administrador.class);
		return c.list();
	}
}