package com.ilegra.engagerace.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ilegra.engagerace.dao.PontuacaoDao;
import com.ilegra.engagerace.dto.PontuacaoDto;
import com.ilegra.engagerace.entity.Pontuacao;

@Component
public class PontuacaoBusiness {
	
	@Autowired private PontuacaoDao pontuacaoDao;
	
	@Transactional
	public void salvaPontuacao(PontuacaoDto dto)  throws Exception{
		Pontuacao pontuacao = new Pontuacao();	
		pontuacao.setIdPontuacao(dto.getIdPontuacao());
		pontuacao.setUsuario(dto.getUsuario());
		pontuacao.setPrograma(dto.getPrograma());
		pontuacao.setData(dto.getData());
		pontuacao.setPontos(dto.getPontos());
		pontuacao.setBonus(dto.getBonus());
		
		if (pontuacao.getIdPontuacao() != null)
			pontuacaoDao.editaPontuacao(pontuacao);
		else
			pontuacaoDao.salvaPontuacao(pontuacao);
	}

	@Transactional
	public void excluiPontuacao(PontuacaoDto dto)  throws Exception{
		Pontuacao pontuacao = new Pontuacao();
		pontuacao.setIdPontuacao(dto.getIdPontuacao());
		pontuacaoDao.excluiPontuacao(pontuacao);
	}

	@Transactional(readOnly=true)
	public List<PontuacaoDto> listaPontuacao() throws ParseException {
		List<PontuacaoDto> list = null;
		List<Pontuacao> pontos = pontuacaoDao.listaPontuacao();

		if (pontos != null && pontos.size() > 0) {
			for (Pontuacao ponto : pontos){
				if (list == null) 
					list = new ArrayList<PontuacaoDto>();
				
				PontuacaoDto dto = new PontuacaoDto();
				dto.setIdPontuacao(ponto.getIdPontuacao());
				dto.setUsuario(ponto.getUsuario());
				dto.setPrograma(ponto.getPrograma());
				dto.setData(ponto.getData());
				dto.setPontuacao(ponto.getPontos());
				dto.setBonus(ponto.getBonus());
				list.add(dto);
			}
		}
		return list;
	}
}