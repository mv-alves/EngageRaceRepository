package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.entity.Pontuacao;

@Repository
public class PontuacaoDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public void editaPontuacao(Pontuacao pontuacao) {
        getCurrentSession().update(pontuacao);
	}

	public void salvaPontuacao(Pontuacao pontuacao) {
        getCurrentSession().save(pontuacao);
	}

	public void excluiPontuacao(Pontuacao pontuacao) {
        getCurrentSession().delete(pontuacao);
	}

	@SuppressWarnings("unchecked")
	public List<Pontuacao> listaPontuacao() {
  	    Criteria c = getCurrentSession().createCriteria(Pontuacao.class);
  	    c.addOrder(Order.desc("pontos"));
  		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Pontuacao> existeRegistroUsuario(Integer idUsuario) {
		Criteria c = getCurrentSession().createCriteria(Pontuacao.class, "PO");
  		c.createAlias("PO.usuario", "U");
		c.add(Restrictions.like("U.idUsuario", idUsuario));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Pontuacao> existeRegistroPrograma(Integer idPrograma) {
		Criteria c = getCurrentSession().createCriteria(Pontuacao.class, "PO");
		c.createAlias("PO.programa", "PR");
		c.add(Restrictions.like("PR.idPrograma", idPrograma));
		return c.list();
	}
}