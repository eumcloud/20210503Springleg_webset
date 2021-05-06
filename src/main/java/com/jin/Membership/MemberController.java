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

	
	
	//��Ʈ�ѷ������� ������ �������� ����!
	// >>��� ���� �� ���͸� �۾��� ���񽺿��� �ؾ� ������ ���ϴ�
	// ��, ���忡�� ����� �ϸ� ���簡�� ���ۿ� ����..
	
	
	
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
			//��ü������ �ڵ�
			String sAuthNum = (String)model.getAttribute("sessionAthNum");
			
		logger.warn(sAuthNum);
			
		if(sAuthNum!=null)
			model.addAttribute("msg", iServ.authConfirm(authNum, sAuthNum , session));
		else
			model.addAttribute("msg", "������ȣ ������ ���� ������ �մϴ�.");
		
		return "forward:/index?formpath=member";

	}
	
	//���̵� �Է��� ȸ�������ϸ� ��������, �ذ��ϱ�
	@RequestMapping(value="memberProc")
	public String memberProc(Model model, Member member){
		
		iServ.MemberProc(member);
		return "forward:/index?formpath=member";
	}
	
	
}
