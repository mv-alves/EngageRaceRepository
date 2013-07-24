package com.ilegra.engagerace.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.ilegra.engagerace.dto.RelatorioDto;
import com.ilegra.engagerace.util.HibernateUtil;

public class RelatorioDao {

	@SuppressWarnings("unchecked")
	public List<RelatorioDto> rankingPorPrograma(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
		Session session = null;
		List<RelatorioDto> lista = null;		
		try{
			session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
	  		session.beginTransaction();
			String sql = "";
			sql+="SELECT SUM(PO.PONTOS+PO.BONUS) AS \"totalpontos\", ";
			sql+="T.TIPOPROGRAMA AS \"tipoprograma\", ";
			sql+="PR.NOMEPROGRAMA AS \"programa\", ";
			sql+="U.NOMEUSUARIO AS \"nomeusuario\", ";
			sql+="A.AREA AS \"area\", ";
			sql+="COUNT(PO.IDPONTUACAO) AS \"ocorrencias\" ";
			sql+="FROM PONTUACAO PO, USUARIO U, PROGRAMA PR, TIPOPROGRAMA T, AREA A ";
			sql+="WHERE PO.USUARIO=U.IDUSUARIO ";
			sql+="AND PO.PROGRAMA=PR.IDPROGRAMA ";
			sql+="AND PR.TIPOPROGRAMA=T.IDTIPOPROGRAMA ";
			sql+="AND U.AREA=A.IDAREA ";
			
			if(usuarioP != null && !usuarioP.equals("0"))
				sql+="AND U.IDUSUARIO = ? ";
			
			if(areaP != null && !areaP.equals("0"))
				sql+= "AND A.IDAREA= ? ";
			
			if(programaP != null && !programaP.equals("0"))
				sql+= "AND PR.IDPROGRAMA= ? ";
				  
			if(tipoP != null && !tipoP.equals("0"))
				sql+= "AND T.IDTIPOPROGRAMA= ? ";
			
			if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals(""))
				sql+= "AND TRUNC(PO.DATA) BETWEEN DATE_FORMAT(data , '%%d/%%m/%%Y') AND DATE_FORMAT(data , '%%d/%%m/%%Y') ";
			
			sql+= "GROUP BY U.NOMEUSUARIO, A.AREA, PR.NOMEPROGRAMA, T.TIPOPROGRAMA ";
			sql+= "ORDER BY \"totalpontos\" DESC, \"tipoprograma\", \"programa\", \"nomeusuario\", \"area\""; 
	  		
	  		Query q = (Query) session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RelatorioDto.class));
	  		
	  		int index = 0;
	  		
	  		if(usuarioP != null && !usuarioP.equals("0"))
	  			q.setInteger(index++, Integer.parseInt(usuarioP));
			
	  		if(areaP != null && !areaP.equals("0"))
	  			q.setInteger(index++, Integer.parseInt(areaP));
			
	  		if(programaP != null && !programaP.equals("0"))
	  	  		q.setInteger(index++, Integer.parseInt(programaP));
			
	  		if(tipoP != null && !tipoP.equals("0"))
	  	  		q.setInteger(index++, Integer.parseInt(tipoP));
			
	  		if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals("")){
	  			q.setString(index++, periodoInicioP);
	  	  		q.setString(index++, periodoFimP);
	  		}
	  		lista = q.list();
	  	
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			session.close();
		}
  		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<RelatorioDto> rankingEngageRace(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
		Session session = null;
  		List<RelatorioDto> lista = null;	
		
  		try{
  			session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
  	  		session.beginTransaction();
  	  				
  			String sql = "";
  			sql+="SELECT SUM(PO.PONTOS+PO.BONUS) AS \"totalpontos\", ";
  			sql+="U.NOMEUSUARIO AS \"nomeusuario\", ";
  			sql+="A.AREA AS \"area\" ";
  			sql+="FROM PONTUACAO PO, USUARIO U, AREA A, PROGRAMA PR, TIPOPROGRAMA T ";
  			sql+="WHERE PO.USUARIO=U.IDUSUARIO ";
			sql+="AND PO.PROGRAMA=PR.IDPROGRAMA ";
			sql+="AND PR.TIPOPROGRAMA=T.IDTIPOPROGRAMA ";
			sql+="AND U.AREA=A.IDAREA ";
  			
  			if(usuarioP != null && !usuarioP.equals("0"))
  				sql+="AND U.IDUSUARIO= ? ";
  			
  			if(areaP != null && !areaP.equals("0"))
  				sql+= "AND A.IDAREA= ? ";
  			
  			if(programaP != null && !programaP.equals("0"))
  				sql+= "AND PR.IDPROGRAMA= ? ";
  			  
  			if(tipoP != null && !tipoP.equals("0"))
  				sql+= "AND T.IDTIPOPROGRAMA= ? ";
  			
  			if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals(""))
  				sql+= "AND TRUNC(PO.DATA) BETWEEN DATE_FORMAT(data , '%%d/%%m/%%Y') AND DATE_FORMAT(data , '%%d/%%m/%%Y') ";
  			
  			sql+= "GROUP BY U.NOMEUSUARIO, A.AREA ";
  			sql+= "ORDER BY \"totalpontos\" DESC, \"nomeusuario\", \"area\""; 
  	  		
  	  		SQLQuery q = (SQLQuery) session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RelatorioDto.class));
  	  		
  	  		int index = 0;
  	  		
	  		if(usuarioP != null && !usuarioP.equals("0"))
	  			q.setInteger(index++, Integer.parseInt(usuarioP));
			  		
  	  		if(areaP != null && !areaP.equals("0"))
  	  			q.setInteger(index++, Integer.parseInt(areaP));
  			
  	  		if(programaP != null && !programaP.equals("0"))
  	  	  		q.setInteger(index++, Integer.parseInt(programaP));
  			
  	  		if(tipoP != null && !tipoP.equals("0"))
  	  	  		q.setInteger(index++, Integer.parseInt(tipoP));
  			
  	  		if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals("")){
	  	  		q.setString(index++, periodoInicioP);
	  	  		q.setString(index++, periodoFimP);
  	  		}
  	  		lista = q.list();
  	  		
  		}catch(Exception e){
  			e.printStackTrace();
  		}finally{
  			session.close();
  		}
	  		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<RelatorioDto> historicoUsuario(String usuarioP, String areaP, String periodoInicioP, String periodoFimP, String programaP, String tipoP) throws Exception {
		Session session = null;
  		List<RelatorioDto> lista = null;

		try{
			session = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
	  		session.beginTransaction();
	  		
			String sql = "";
			sql+="SELECT DATE_FORMAT(data , '%%d/%%m/%%Y') AS \"data\", ";
			sql+="PO.PONTOS AS \"pontos\", ";
			sql+="PO.BONUS AS \"bonus\", ";
			sql+="T.TIPOPROGRAMA AS \"tipoprograma\", ";
			sql+="PR.NOMEPROGRAMA AS \"programa\",  ";
			sql+="U.NOMEUSUARIO AS \"nomeusuario\", ";
			sql+="A.AREA AS \"area\" ";
			sql+="FROM PONTUACAO PO, USUARIO U, AREA A, PROGRAMA PR, TIPOPROGRAMA T ";
  			sql+="WHERE PO.USUARIO=U.IDUSUARIO ";
			sql+="AND PO.PROGRAMA=PR.IDPROGRAMA ";
			sql+="AND PR.TIPOPROGRAMA=T.IDTIPOPROGRAMA ";
			sql+="AND U.AREA=A.IDAREA ";
  			
			if(usuarioP != null && !usuarioP.equals("0"))
				sql+="AND U.IDUSUARIO = ? ";
			
			if(areaP != null && !areaP.equals("0"))
				sql+= "AND A.IDAREA= ? ";
			
			if(programaP != null && !programaP.equals("0"))
				sql+= "AND PR.IDPROGRAMA= ? ";
			
			if(tipoP != null && !tipoP.equals("0"))
				sql+= "AND T.IDTIPOPROGRAMA= ? ";
			
			if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals(""))
				sql+= "AND TRUNC(PO.DATA) BETWEEN DATE_FORMAT(data , '%%d/%%m/%%Y') AND DATE_FORMAT(data , '%%d/%%m/%%Y') ";
			
			sql+= "ORDER BY \"data\" DESC, \"tipoprograma\", \"programa\", \"area\"";
	  		
	  		SQLQuery q = (SQLQuery) session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(RelatorioDto.class));
	  		
	  		int index = 0;

	  		if(usuarioP != null && !usuarioP.equals("0"))
	  			q.setInteger(index++, Integer.parseInt(usuarioP));
			  	  			  		
	  		if(areaP != null && !areaP.equals("0"))
	  			q.setInteger(index++, Integer.parseInt(areaP));
			
	  		if(programaP != null && !programaP.equals("0"))
	  	  		q.setInteger(index++, Integer.parseInt(programaP));
			
	  		if(tipoP != null && !tipoP.equals("0"))
	  	  		q.setInteger(index++, Integer.parseInt(tipoP));
			
	  		if(periodoInicioP != null && !periodoInicioP.equals("") && periodoFimP != null && !periodoFimP.equals("")){
	  			q.setString(index++, periodoInicioP);
	  	  		q.setString(index++, periodoFimP);
			} 		
	  		  		
	  		lista = q.list();
	  	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
  		return lista;
	}
}