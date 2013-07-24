package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ilegra.engagerace.entity.Pontuacao;
import com.ilegra.engagerace.util.HibernateUtil;

public class PontuacaoDao {

	public void editaPontuacao(Pontuacao pontuacao) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = (Session) factory.getCurrentSession();
        session.beginTransaction();
        session.update(pontuacao);
        session.getTransaction().commit();
        session.close();
	}

	public void salvaPontuacao(Pontuacao pontuacao) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(pontuacao);
        session.getTransaction().commit();	
        session.close();
	}

	public void excluiPontuacao(Pontuacao pontuacao) {
		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(pontuacao);
        session.getTransaction().commit();	
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Pontuacao> listaPontuacao() {
		List<Pontuacao> pontos = null;
  		Session session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  		session.beginTransaction();
  	    Criteria c = session.createCriteria(Pontuacao.class);
  	    
  	    pontos = c.list();
  	    session.close();  		  		
  		return pontos;
	}
}