package com.ilegra.engagerace.test;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.ilegra.engagerace.dao.PontuacaoDao;
import com.ilegra.engagerace.dao.RelatorioDao;
import com.ilegra.engagerace.dto.RelatorioDto;
import com.ilegra.engagerace.entity.Pontuacao;

public class EngageTest extends TestCase {
	public void testHibernateListaPontuacao() throws Exception {
		PontuacaoDao dao = new PontuacaoDao();
		List<Pontuacao> lista = dao.listaPontuacao();
		Assert.assertTrue("lista nao é maior que 0", (lista.size() > 0));
	}
	
//	public void testBusinessListaPontuacao() throws Exception {			
//		List<PontuacaoDto> lista = PontuacaoBusiness.listaPontuacao();
//		Assert.assertTrue("lista nao é maior que 0", (lista.size() > 0));
//	}

	public void testRelatorioDao() throws Exception {
		RelatorioDao dao = new RelatorioDao();
		List<RelatorioDto> lista = dao.rankingEngageRace(null, null, null, null, null, null);
		Assert.assertTrue("lista nao é maior que 0", (lista.size() > 0));
	}
	
//	public void testRelatorio() throws Exception {
//		List<RelatorioDto> lista = RelatorioBusiness.rankingEngageRace(null, null, null, null, null, null);
//		Assert.assertTrue("lista nao é maior que 0", (lista.size() > 0));
//	}
}