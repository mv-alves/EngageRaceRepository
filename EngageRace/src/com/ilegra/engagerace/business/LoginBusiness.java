package com.ilegra.engagerace.business;

import com.ilegra.engagerace.dao.LoginDao;
import com.ilegra.engagerace.dto.LoginDto;
import com.ilegra.engagerace.entity.Administrador;

public class LoginBusiness {
	public static Integer confirmaLogin(LoginDto dto) throws Exception {
		LoginDao loginDao = new LoginDao();
		Administrador admin = loginDao.confirmaLogin(dto);
		if (admin != null)
			return admin.getIdAdministrador();
		return null;
	}
}
