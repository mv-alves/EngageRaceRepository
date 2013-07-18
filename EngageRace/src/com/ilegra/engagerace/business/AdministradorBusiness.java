package com.ilegra.engagerace.business;

import java.util.ArrayList;
import java.util.List;

import com.ilegra.engagerace.dao.AdministradorDao;
import com.ilegra.engagerace.dto.AdministradorDto;
import com.ilegra.engagerace.entity.Administrador;

public class AdministradorBusiness {
	
	static AdministradorDao administradorDao = new AdministradorDao();

	public static void salvaAdministrador(AdministradorDto dto) throws Exception{
		Administrador administrador = new Administrador();	
		administrador.setIdAdministrador(dto.getIdAdministrador());
		administrador.setLogin(dto.getLogin());
		administrador.setSenha(dto.getSenha());

		if (administrador.getIdAdministrador() != null)
			administradorDao.editaAdministrador(administrador);
		else
			administradorDao.salvaAdministrador(administrador);
	}

	public static void excluiAdministrador(AdministradorDto dto) throws Exception{
		Administrador administrador = new Administrador();
		administrador.setIdAdministrador(dto.getIdAdministrador());
		administradorDao.excluiAdministrador(administrador);
	}

	public static List<AdministradorDto> listaAdminstrador() throws Exception{
		List<AdministradorDto> list = null;
		List<Administrador> administradores = administradorDao.pesquisaAdministrador();

		if (administradores != null && administradores.size() > 0) {
			for (Administrador administrador : administradores){
				if (list == null) 
					list = new ArrayList<AdministradorDto>();

				AdministradorDto dto = new AdministradorDto();
				dto.setIdAdministrador(administrador.getIdAdministrador());
				dto.setLogin(administrador.getLogin());
				dto.setSenha(administrador.getSenha());
				list.add(dto);
			}
		}
		return list;
	}
}
