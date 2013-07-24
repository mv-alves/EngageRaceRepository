package com.ilegra.engagerace.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.ilegra.engagerace.dto.LoginDto;
import com.ilegra.engagerace.entity.Administrador;
import com.ilegra.engagerace.util.HibernateUtil;

public class LoginDao {

	public Administrador confirmaLogin(LoginDto dto) throws Exception{
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(Administrador.class);
  	    String login = dto.getLoginAdmin();
  	    String senha = dto.getSenhaAdmin(); 
  	  	    
	    if(login != null && senha != null){  	    	
	    	c.add(Restrictions.eq("login", login));
	    	c.add(Restrictions.eq("senha", senha));
	    }
	    Administrador result = (Administrador)c.uniqueResult();	    
	    session.close();
	    return result;
	}
}
