package com.ilegra.engagerace.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ilegra.engagerace.dao.LoginDao;
import com.ilegra.engagerace.dto.LoginDto;
import com.ilegra.engagerace.entity.Administrador;

@Component
public class LoginBusiness {
	
	@Autowired private LoginDao loginDao;

	@Transactional(readOnly=true)
	public Integer confirmaLogin(LoginDto dto) throws Exception {
		Administrador admin = loginDao.confirmaLogin(dto);
		if (admin != null)
			return admin.getIdAdministrador();
		return null;
	}
}
