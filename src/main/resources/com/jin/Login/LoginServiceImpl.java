package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.Membership.Login;
import com.jin.mail.SHA;

@Service
public class LoginServiceImpl implements ILoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired private ILoginDao iLoginDao;
	@Autowired private HttpSession session;
	
	/*
	 * ���ǿ� ������ �����ϴ� �޼ҵ�
	 * id, ���� �� �α��ν� ������ ���� ����
	 */
	private void setSession(int cnt, String id) {
		if(cnt==1) {
			session.setAttribute("id", id);
		}
	}
	@Override
	public int LoginProc(Login login) {
//		SHA sha = new SHA();
//		String encyptPw = sha.encryptSHA512(login.getPw());
//		login.setPw(encyptPw);
		
		login.setPw((new SHA()).encryptSHA512(login.getPw()));
		int cnt = iLoginDao.LoginProc(login);
		setSession(cnt, login.getId());
		
		return cnt;
	}
}
