package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jin.Membership.Login;
import com.jin.mail.SHA;

@Service
public class LoginServiceImpl implements ILoginService{
	final String LOGINAPROVE = "로그인에 성공하였습니다";
	final String LOGINFAILED = "아이디와 비밀번호를 확인하세요";
	
	@Autowired private ILoginDao Dao;
	@Autowired private HttpSession session;
	
	private void setSession(int cnt, String id) {
		if (cnt==1) {
			session.setAttribute("id", id);
		}
	}
	
	@Override
	public String LoginProc(Login login) {
//		SHA sha = new SHA();
//		String encryptPw = sha.encryptSHA512(login.getPw());
//		login.setPw(encryptPw);  //아래와같이 한줄로 가능
		 login.setPw((new SHA()).encryptSHA512(login.getPw()));
//		 return iLoginDao.LoginProc(login);
		int selectid = Dao.idSelect(login);
		
		if("1".contentEquals(String.valueOf(selectid))) {return LOGINAPROVE;}
		/* if("0".contentEquals(String.valueOf(selectid)) ) { */return LOGINFAILED;/* } */
	}



	
	
}
