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
	1.서비스까지 데이터 전달
	2.DB확인 결과얻기(서비스에서 확인)
	3. 로그인시 메뉴 변경 로그인 성공(홈, 게시판) 실패(홈, 로그인, 회원가입)
	*/
	final String LOGINAPROVE = "로그인에 성공하였습니다";
	final String LOGINFAILED = "아이디와 비밀번호를 확인하세요";
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
