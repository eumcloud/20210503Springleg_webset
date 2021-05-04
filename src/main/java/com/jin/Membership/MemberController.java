package com.jin.Membership;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("membership")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private IMemberService iMemberServ;
	
	//��Ʈ�ѷ������� ������ �������� ����!
	// >>��� ���� �� ���͸� �۾��� ���񽺿��� �ؾ� ������ ���ϴ�
	// ��, ���忡�� ����� �ϸ� ���簡�� ���ۿ� ����..
	@RequestMapping(value = "isExistID")
	public String isExistID1(Model model, Login login) {
		
		
		
		model.addAttribute("msg", iMemberServ.isExistID(login));
		return "forward:/index?formpath=member";
	}
	
}
