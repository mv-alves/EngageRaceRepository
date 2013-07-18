package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.ilegra.engagerace.entity.Area;
import com.ilegra.engagerace.util.HibernateUtil;

public class AreaDao {

	@SuppressWarnings("unchecked")
	public List<Area> listaAreas() {
		List<Area> tipos = null;
  		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(Area.class);
  	    tipos = c.list();
  	    session.getTransaction().commit();
  		return tipos;
	}
}
