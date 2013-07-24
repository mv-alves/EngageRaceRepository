package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import com.ilegra.engagerace.entity.TipoPrograma;
import com.ilegra.engagerace.util.HibernateUtil;

public class TipoProgramaDao {

	@SuppressWarnings("unchecked")
	public List<TipoPrograma> listaTipoPrograma() {
		List<TipoPrograma> tipos = null;
  		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(TipoPrograma.class);
  	    tipos = c.list();
  	    session.close();
  		return tipos;
	}
}