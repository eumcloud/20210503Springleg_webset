package com.jin.Membership;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String sendAuth(Model model, Member member, HttpSession session){
		
		/* String authNum= */iServ.sendAuth(member, session);
//		session.setAttribute("authSess", authNum);
//		model.addAttribute("authNum", authNum);
		
//			logger.warn(authNum);
		model.addAttribute("msg", "�̸����� Ȯ���ϼ���");
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value="authConfirm")
	public String authConfirm(Model model, Member member,
			@RequestParam String authNum
			 ,HttpSession session){
		
			
//		if(sAuthNum!=null)//������ȣ �Է��� ���
//			model.addAttribute("msg", iServ.authConfirm(authNum, session));
//		else
//			model.addAttribute("msg", "������ȣ ������ ���� ������ �մϴ�.");
		
		return "forward:/index?formpath=member";

	}
	
	//���̵� �Է��� ȸ�������ϸ� ��������, �ذ��ϱ�
	@RequestMapping(value="memberProc")
	public String memberProc(Model model, Member member, Postcode postcode, HttpSession session){
		Boolean authStatus =(Boolean) session.getAttribute("authStatus");
//		logger.warn(authSatus+"");
		
		if(authStatus ) iServ.MemberProc(member, postcode);
		else model.addAttribute("msg", "������ �����ؾ��մϴ�");
		
		
//		iServ.MemberProc(member, postcode, HttpSession session);
		return "forward:/index?formpath=member";
	}
	
	
	
	@RequestMapping(value="searchZipcode")
	public String searchZipcode(Model model,
					@RequestParam String addr
			) {
		logger.warn(addr); //���� �� �޾����� ���ڵ��� �ȵǼ� ����
		
		List<Zipcode> zipcodelst = iServ.Searchzipcode(addr);
		model.addAttribute("zipcodelst", zipcodelst);

		return "member/SearchPostCode";
	}
	
	
}
