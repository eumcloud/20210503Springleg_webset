package com.jin.Membership;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String sendAuth(Model model, Member member) {
		iMemberServ.sendAuth(member);

		model.addAttribute("msg", "이메일을 확인하세요");
		return "forward:/index?formpath=member";
	}

	@RequestMapping(value = "authConfirm")
	public String authConfirm(Model model, Member member, @RequestParam String authNum) {
		model.addAttribute("msg", iMemberServ.authConfirm(authNum));

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
