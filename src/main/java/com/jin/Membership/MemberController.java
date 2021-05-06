package com.jin.Membership;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
@Controller
@RequestMapping("membership")
@SessionAttributes("sessionAuthNum")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private IMemberService iServ;

	
	
	//컨트롤러에서는 데이터 가공하지 말것!
	// >>모든 가공 및 필터링 작업은 서비스에서 해야 수정이 편하다
	// 단, 현장에서 맘대로 하면 맞춰가는 수밖에 없다..
	
	
	
	@RequestMapping(value = "isExistID")
	public String isExistID(Model model, Login login) {
		
		model.addAttribute("msg", iServ.isExistID(login));
		return "forward:/index?formpath=member";
	}
	
	@RequestMapping(value="sendAuth")
	public String sendAuth(Model model, Member member){
		String authNum= iServ.sendAuth(member);
		
		
		
		model.addAttribute("sessionAuthNum", authNum);
		model.addAttribute("msg", authNum);
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value="authConfirm")
	public String authConfirm(Model model, Member member,
			@RequestParam String authNum
			/* ,@ModelAttribute("sessionAuthNum") ,String sAuthNum*/
			 ,SessionStatus session			){
			//대체가능한 코드
			String sAuthNum = (String)model.getAttribute("sessionAthNum");
			
		logger.warn(sAuthNum);
			
		if(sAuthNum!=null)
			model.addAttribute("msg", iServ.authConfirm(authNum, sAuthNum , session));
		else
			model.addAttribute("msg", "인증번호 전송을 먼저 눌러야 합니다.");
		
		return "forward:/index?formpath=member";

	}
	
	//아이디만 입력후 회원가입하면 에러난다, 해결하기
	@RequestMapping(value="memberProc")
	public String memberProc(Model model, Member member){
		
		iServ.MemberProc(member);
		return "forward:/index?formpath=member";
	}
	
	
}
