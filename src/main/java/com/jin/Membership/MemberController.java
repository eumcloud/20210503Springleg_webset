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
	
	//컨트롤러에서는 데이터 가공하지 말것!
	// >>모든 가공 및 필터링 작업은 서비스에서 해야 수정이 편하다
	// 단, 현장에서 맘대로 하면 맞춰가는 수밖에 없다..
	@RequestMapping(value = "isExistID")
	public String isExistID1(Model model, Login login) {
		
		
		
		model.addAttribute("msg", iMemberServ.isExistID(login));
		return "forward:/index?formpath=member";
	}
	
}
