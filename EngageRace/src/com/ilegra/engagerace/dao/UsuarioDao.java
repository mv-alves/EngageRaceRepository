package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.ilegra.engagerace.entity.Usuario;
import com.ilegra.engagerace.util.HibernateUtil;

public class UsuarioDao {

	public void salvaUsuario(Usuario usuario) {
		 Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
	     session.beginTransaction();
	     session.save(usuario);
	     session.getTransaction().commit();
	}

	public void excluiUsuario(Usuario usuario) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
	}

	public void editaUsuario(Usuario usuario) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> pesquisaUsuario(String nome) {
		List<Usuario> usuarios = null;
  		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(Usuario.class);
  	    
  	    if(nome != null)    	
  	    	c.add(Restrictions.like("nomeUsuario", "%" + nome.toLowerCase() + "%").ignoreCase());
  	    
  		usuarios = c.list();
  	    session.getTransaction().commit();
  		  		
  		return usuarios;
	}
}