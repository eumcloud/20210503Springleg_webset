package com.jin.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

@Controller
@RequestMapping("/Member")
public class LoginController {


	@Autowired
	private ILoginService iServ;
	
	@RequestMapping(value="login")
	public String LoginForm(Model model, Login login) {
		
		
		
		model.addAttribute("formpath", "loginForm");
		return "index";
	}
	
	@RequestMapping(value="loginProc")
	public String loginProc(Model model, Login login) {
		
		iServ.Login(login);
		
		if(!loginok) {return "foward:/index?formpath=login";}
		
		return "index";
	}
	

}
