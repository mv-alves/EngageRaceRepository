package com.ilegra.engagerace.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ilegra.engagerace.dao.UsuarioDao;
import com.ilegra.engagerace.dto.UsuarioDto;
import com.ilegra.engagerace.entity.Usuario;

@Component
public class UsuarioBusiness {
	
	@Autowired private UsuarioDao usuarioDao;

	@Transactional
	public void salvaUsuario(UsuarioDto dto) throws Exception{
		Usuario usuario = new Usuario();	
		usuario.setIdUsuario(dto.getIdUsuario());
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setArea(dto.getArea());
		usuario.setEmail(dto.getEmail());

		if (usuario.getIdUsuario() != null)
			usuarioDao.editaUsuario(usuario);
		else
			usuarioDao.salvaUsuario(usuario);
	}

	@Transactional
	public void excluiUsuario(UsuarioDto dto) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(dto.getIdUsuario());
		usuarioDao.excluiUsuario(usuario);
	}

	@Transactional (readOnly=true)
	public List<UsuarioDto> pesquisaUsuario(String chave) throws Exception{
		List<UsuarioDto> list = null;
		List<Usuario> usuarios = usuarioDao.pesquisaUsuario(chave);

		if (usuarios != null && usuarios.size() > 0) {
			for (Usuario usuario : usuarios){
				if (list == null) 
					list = new ArrayList<UsuarioDto>();

				UsuarioDto dto = new UsuarioDto();
				dto.setIdUsuario(usuario.getIdUsuario());
				dto.setNomeUsuario(usuario.getNomeUsuario());
				dto.setArea(usuario.getArea());
				dto.setEmail(usuario.getEmail());
				list.add(dto);
			}
		}
		return list;
	}
}