package com.ilegra.engagerace.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ilegra.engagerace.dto.RelatorioDto;
import com.ilegra.engagerace.entity.Pontuacao;

@Repository
public class RelatorioDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<RelatorioDto> rankingPorPrograma(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {

			Criteria c = getCurrentSession().createCriteria(Pontuacao.class, "PO");
	  		c.createAlias("PO.usuario", "U");
	  		c.createAlias("PO.programa", "PR");
	  		c.createAlias("PR.tipoPrograma", "T");
	  		c.createAlias("U.area", "A");
	  		
	  		c.setProjection(
	  				Projections.projectionList()
	  				.add(Projections.alias(
	  						Projections.sqlProjection("sum(pontos+bonus) as totalPontos", new String[] {"totalPontos"} , new Type[] {IntegerType.INSTANCE})
	  						, "totalPontos")
	  				)
	  				.add(Projections.count("PO.idPontuacao"), "ocorrencias")
	  				.add(Projections.property("T.tipoPrograma"), "tipoPrograma")
	  				.add(Projections.property("PR.nomePrograma"), "programa")
	  				.add(Projections.property("U.nomeUsuario"), "nomeUsuario")
	  				.add(Projections.property("A.area"), "area")
	  				.add(Projections.groupProperty("U.nomeUsuario"))
		    		.add(Projections.groupProperty("A.area"))
		    		.add(Projections.groupProperty("PR.nomePrograma"))
		    		.add(Projections.groupProperty("T.tipoPrograma"))
	  		);
	  		
			if(usuarioP != null && !usuarioP.equals("0"))
				c.add(Restrictions.like("U.idUsuario", Integer.parseInt(usuarioP)));
			
			if(areaP != null && !areaP.equals("0"))
				c.add(Restrictions.like("A.idArea", Integer.parseInt(areaP)));

			if(programaP != null && !programaP.equals("0"))
				c.add(Restrictions.like("PR.idPrograma", Integer.parseInt(programaP)));
				  
			if(tipoP != null && !tipoP.equals("0"))
				c.add(Restrictions.like("T.idTipoPrograma", Integer.parseInt(tipoP)));
			
			if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals("")){
				String[] dataInicio = periodoInicioP.split("/");

				Calendar calendarInicio = Calendar.getInstance();
				calendarInicio.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataInicio[0]));
				calendarInicio.set(Calendar.MONTH, Integer.parseInt(dataInicio[1]) -1);
				calendarInicio.set(Calendar.YEAR, Integer.parseInt(dataInicio[2]));	
				
				String[] dataFim = periodoFimP.split("/");
				
				Calendar calendarFim = Calendar.getInstance();
				calendarFim.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataFim[0]));
				calendarFim.set(Calendar.MONTH, Integer.parseInt(dataFim[1]) -1);
				calendarFim.set(Calendar.YEAR, Integer.parseInt(dataFim[2]));
				
				c.add(Restrictions.between("PO.data", calendarInicio.getTime(), calendarFim.getTime()));
			}
			
			c.addOrder(Order.desc("totalPontos"));
			c.addOrder(Order.asc("tipoPrograma"));
			c.addOrder(Order.asc("programa"));
			c.addOrder(Order.asc("nomeUsuario"));
			c.addOrder(Order.asc("area"));
			
			c.setResultTransformer(Transformers.aliasToBean(RelatorioDto.class));
			return (List<RelatorioDto>)c.setCacheable(false).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelatorioDto> rankingEngageRace(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
  	  		
	  	  	Criteria c = getCurrentSession().createCriteria(Pontuacao.class, "PO");
	  		c.createAlias("PO.usuario", "U");
	  		c.createAlias("PO.programa", "PR");
	  		c.createAlias("PR.tipoPrograma", "T");
	  		c.createAlias("U.area", "A");
	  		
	  		c.setProjection(
	  				Projections.projectionList()
	  				.add(Projections.alias(
	  						Projections.sqlProjection("sum(pontos+bonus) as totalPontos", new String[] {"totalPontos"} , new Type[] {IntegerType.INSTANCE})
	  						, "totalPontos")
	  				)	  				
	  				.add(Projections.property("U.nomeUsuario"), "nomeUsuario")
	  				.add(Projections.property("A.area"), "area")
	  				.add(Projections.groupProperty("U.nomeUsuario"))
		    		.add(Projections.groupProperty("A.area"))
	  		);
	  		
  			if(usuarioP != null && !usuarioP.equals("0"))
  				c.add(Restrictions.like("U.idUsuario", Integer.parseInt(usuarioP)));
  			
  			if(areaP != null && !areaP.equals("0"))
				c.add(Restrictions.like("A.idArea", Integer.parseInt(areaP)));
  			
  			if(programaP != null && !programaP.equals("0"))
  				c.add(Restrictions.like("PR.idPrograma", Integer.parseInt(programaP)));
  			  
  			if(tipoP != null && !tipoP.equals("0"))
				c.add(Restrictions.like("T.idTipoPrograma", Integer.parseInt(tipoP)));
  			
  			if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals("")){
  				String[] dataInicio = periodoInicioP.split("/");

				Calendar calendarInicio = Calendar.getInstance();
				calendarInicio.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataInicio[0]));
				calendarInicio.set(Calendar.MONTH, Integer.parseInt(dataInicio[1]) -1);
				calendarInicio.set(Calendar.YEAR, Integer.parseInt(dataInicio[2]));	
				
				String[] dataFim = periodoFimP.split("/");
				
				Calendar calendarFim = Calendar.getInstance();
				calendarFim.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataFim[0]));
				calendarFim.set(Calendar.MONTH, Integer.parseInt(dataFim[1]) -1);
				calendarFim.set(Calendar.YEAR, Integer.parseInt(dataFim[2]));
				
				c.add(Restrictions.between("PO.data", calendarInicio.getTime(), calendarFim.getTime()));
  			}
  			
  			c.addOrder(Order.desc("totalPontos"));
			c.addOrder(Order.asc("nomeUsuario"));
			c.addOrder(Order.asc("area"));
			
			c.setResultTransformer(Transformers.aliasToBean(RelatorioDto.class));
			return (List<RelatorioDto>)c.setCacheable(false).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RelatorioDto> historicoUsuario(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
	  		
	  	  	Criteria c = getCurrentSession().createCriteria(Pontuacao.class, "PO");
	  		c.createAlias("PO.usuario", "U");
	  		c.createAlias("PO.programa", "PR");
	  		c.createAlias("PR.tipoPrograma", "T");
	  		c.createAlias("U.area", "A");
	  		
	  		c.setProjection(
	  				Projections.projectionList()
	  				.add(Projections.property("PO.data"), "data")			
	  				.add(Projections.property("PO.pontos"), "pontos")
	  				.add(Projections.property("PO.bonus"), "bonus")
	  				.add(Projections.property("T.tipoPrograma"), "tipoPrograma")
	  				.add(Projections.property("PR.nomePrograma"), "programa")
	  				.add(Projections.property("U.nomeUsuario"), "nomeUsuario")
	  				.add(Projections.property("A.area"), "area")
	  		);
	  		
			if(usuarioP != null && !usuarioP.equals("0"))
				c.add(Restrictions.like("U.idUsuario", Integer.parseInt(usuarioP)));
			
			if(areaP != null && !areaP.equals("0"))
				c.add(Restrictions.like("A.idArea", Integer.parseInt(areaP)));
			
			if(programaP != null && !programaP.equals("0"))
				c.add(Restrictions.like("PR.idPrograma", Integer.parseInt(programaP)));
			
			if(tipoP != null && !tipoP.equals("0"))
				c.add(Restrictions.like("T.idTipoPrograma", Integer.parseInt(tipoP)));
			
			if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals("")){

				String[] dataInicio = periodoInicioP.split("/");

				Calendar calendarInicio = Calendar.getInstance();
				calendarInicio.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataInicio[0]));
				calendarInicio.set(Calendar.MONTH, Integer.parseInt(dataInicio[1]) -1);
				calendarInicio.set(Calendar.YEAR, Integer.parseInt(dataInicio[2]));	
				
				String[] dataFim = periodoFimP.split("/");
				
				Calendar calendarFim = Calendar.getInstance();
				calendarFim.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataFim[0]));
				calendarFim.set(Calendar.MONTH, Integer.parseInt(dataFim[1]) -1);
				calendarFim.set(Calendar.YEAR, Integer.parseInt(dataFim[2]));
				
				c.add(Restrictions.between("PO.data", calendarInicio.getTime(), calendarFim.getTime()));
			}
			c.addOrder(Order.desc("data"));
			c.addOrder(Order.asc("tipoPrograma"));
			c.addOrder(Order.asc("programa"));
			c.addOrder(Order.asc("area"));
			
			c.setResultTransformer(Transformers.aliasToBean(RelatorioDto.class));
			return (List<RelatorioDto>)c.setCacheable(false).list();
	}
}