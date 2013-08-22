package com.ilegra.engagerace.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.dto.LoginDto;
import com.ilegra.engagerace.entity.Administrador;

@Repository
public class LoginDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public Administrador confirmaLogin(LoginDto dto) throws Exception{
  	    Criteria c = getCurrentSession().createCriteria(Administrador.class);
  	    String login = dto.getLoginAdmin();
  	    String senha = dto.getSenhaAdmin(); 
  	  	    
	    if(login != null && senha != null){  	    	
	    	c.add(Restrictions.eq("login", login));
	    	c.add(Restrictions.eq("senha", senha));
	    }
	    return (Administrador)c.uniqueResult();	
	}
}
