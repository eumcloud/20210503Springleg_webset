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

import com.jin.mail.SHA;
@Controller
@RequestMapping("membership")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private IMemberService iMemberServ;

	@RequestMapping(value = "isExistID")
	public String isExistID1(Model model, Login login) {
		SHA sha = new SHA();
		logger.warn(sha.encryptSHA512(login.getPw()));
		model.addAttribute("msg", iMemberServ.IsExistID(login));
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value = "sendAuth")
	public String sendAuth(Model model, Member member/* , HttpSession session */) {
		/* String authNum = */iMemberServ.sendAuth(member);
//		session.setAttribute("sessionAuthNum", authNum);
		model.addAttribute("msg", "이메일을 확인하세요");
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value = "authConfirm")
	public String authConfirm(Model model, Member member, @RequestParam String authNum/* , HttpSession session */) {
		model.addAttribute("msg", iMemberServ.authConfirm(authNum/* , session */));

//		logger.warn((String) session.getAttribute("sessionAuthNum"));
//		session.setMaxInactiveInterval(1);
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value = "memberProc")
	public String memberProc(Model model, Member member, Postcode postcode) {
		String msg = iMemberServ.MemberProc(member, postcode);

		model.addAttribute("msg", msg);
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value = "searchPostcode")
	public String searchPostcode() {
		return "Member/searchPostcodeForm";
	}

	@RequestMapping(value = "searchZipcode")
	public String searchZipcode(Model model, @RequestParam String addr) {
		List<Zipcode> zipcodeLst = iMemberServ.SearchZipcode(addr);
		model.addAttribute("zipcodeLst", zipcodeLst);
		return "Member/searchPostcodeForm";
	}
	
}
