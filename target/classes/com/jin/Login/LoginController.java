package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.Membership.Login;

@Controller
@RequestMapping("login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired private ILoginService iLoginServ;
	private final int LOGINSUCCESS = 1;
	
	@RequestMapping(value = "loginProc")
	public String loginProc(Model model, Login login) {
		int loginResult = iLoginServ.LoginProc(login);
		if(loginResult==LOGINSUCCESS) 
			return "forward:/index?formpath=home";

		model.addAttribute("msg", "잘못된 계정정보입니다.");
		return "forward:/index?formpath=login";
	}
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/index?formpath=home";
	}
}
