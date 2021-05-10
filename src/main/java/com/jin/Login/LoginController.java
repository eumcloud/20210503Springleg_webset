package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

@Controller
@RequestMapping("login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/*
	1.���񽺱��� ������ ����
	2.DBȮ�� ������(���񽺿��� Ȯ��)
	3. �α��ν� �޴� ���� �α��� ����(Ȩ, �Խ���) ����(Ȩ, �α���, ȸ������)
	*/
	final String LOGINAPROVE = "�α��ο� �����Ͽ����ϴ�";
	final String LOGINFAILED = "���̵�� ��й�ȣ�� Ȯ���ϼ���";
	@Autowired private ILoginService iServ;
	@Autowired private HttpSession session;
	
	@RequestMapping(value="login")
	public String LoginForm(Model model, Login login) {
		
		model.addAttribute("formpath", "loginForm");
		return "index";
	}
	
	@RequestMapping(value="loginProc")
	public String loginProc(Model model, Login login) {
		
		logger.warn(login.getId());
		String loginchk = iServ.LoginProc(login);
		if(LOGINFAILED.contentEquals(loginchk)) {
			return "foward:/index?formpath=login";}
		model.addAttribute("msg", loginchk);
		
		return "forward:/index?formpath=home";
	}
	
	@RequestMapping(value="logoutProc")
	public String logoutProc(Login login) {
		session.invalidate();
		/*
		 * String id = (String) session.getAttribute(login.getId());
		 * session.removeAttribute(id);
		 */
		return "forward:/index?formpath=home";
	}

}
