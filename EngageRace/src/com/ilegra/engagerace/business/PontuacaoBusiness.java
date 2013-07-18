package com.ilegra.engagerace.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ilegra.engagerace.dao.PontuacaoDao;
import com.ilegra.engagerace.dto.PontuacaoDto;
import com.ilegra.engagerace.entity.Pontuacao;

public class PontuacaoBusiness {
	
	static PontuacaoDao pontuacaoDao = new PontuacaoDao();

	public static void salvaPontuacao(PontuacaoDto dto)  throws Exception{
		Pontuacao pontuacao = new Pontuacao();	
		pontuacao.setIdPontuacao(dto.getIdPontuacao());
		pontuacao.setUsuario(dto.getUsuario());
		pontuacao.setPrograma(dto.getPrograma());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse(dto.getData());		
		
		pontuacao.setData(data);
		pontuacao.setPontos(dto.getPontos());
		pontuacao.setBonus(dto.getBonus());
		
		if (pontuacao.getIdPontuacao() != null)
			pontuacaoDao.editaPontuacao(pontuacao);
		else
			pontuacaoDao.salvaPontuacao(pontuacao);
	}

	public static void excluiPontuacao(PontuacaoDto dto)  throws Exception{
		Pontuacao pontuacao = new Pontuacao();
		pontuacao.setIdPontuacao(dto.getIdPontuacao());
		pontuacaoDao.excluiPontuacao(pontuacao);
	}

	public static List<PontuacaoDto> listaPontuacao() {
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
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String data = sdf.format(ponto.getData());
				
				dto.setData(data);
				dto.setPontuacao(ponto.getPontos());
				dto.setBonus(ponto.getBonus());
				list.add(dto);
			}
		}
		return list;
	}
}