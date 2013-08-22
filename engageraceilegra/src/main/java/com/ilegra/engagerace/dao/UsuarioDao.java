package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.entity.Usuario;

@Repository
public class UsuarioDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void salvaUsuario(Usuario usuario) {
		getCurrentSession().save(usuario);
	}

	public void excluiUsuario(Usuario usuario) {
		getCurrentSession().delete(usuario);
	}

	public void editaUsuario(Usuario usuario) {
		getCurrentSession().update(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisaUsuario(String nome) {
  	    Criteria c = getCurrentSession().createCriteria(Usuario.class);

  	    if(nome != null)    	
  	    	c.add(Restrictions.ilike("nomeUsuario", nome.toLowerCase(), MatchMode.ANYWHERE));
  	    
  	    c.addOrder(Order.asc("nomeUsuario"));
  		return c.list();
	}
}