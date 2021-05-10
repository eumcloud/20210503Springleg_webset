package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jin.Membership.Login;

@Service
public class LoginServiceImpl {
	final String LOGINAPROVE = "로그인에 성공하였습니다";
	final String LIGINFAILED = "아이디와 비밀번호를 확인하세요";
	
	
	@Autowired
	private ILoginDao Dao;
	
	public String Login (Login login,  HttpSession session) {
		
		int selectid = Dao.idSelect(login);
		
		if("1".contentEquals(String.valueOf(selectid))) {return LOGINAPROVE;}
		/* if("0".contentEquals(String.valueOf(selectid)) ) { */return LIGINFAILED;/* } */
	}
	
}
