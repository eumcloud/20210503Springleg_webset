package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jin.Membership.Login;

@Service
public class LoginServiceImpl {
	final String LOGINAPROVE = "�α��ο� �����Ͽ����ϴ�";
	final String LIGINFAILED = "���̵�� ��й�ȣ�� Ȯ���ϼ���";
	
	
	@Autowired
	private ILoginDao Dao;
	
	public String Login (Login login,  HttpSession session) {
		
		int selectid = Dao.idSelect(login);
		
		if("1".contentEquals(String.valueOf(selectid))) {return LOGINAPROVE;}
		/* if("0".contentEquals(String.valueOf(selectid)) ) { */return LIGINFAILED;/* } */
	}
	
}
