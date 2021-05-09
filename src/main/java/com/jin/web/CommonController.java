package com.jin.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
//	@RequestMapping(value = "/")
//	public String index(Model model) {
//		model.addAttribute("formpath", "home");
//		return "index";
//	}
	@RequestMapping(value = "/index")
	public String index(Model model,
			@RequestParam String formpath) {
		model.addAttribute("formpath", formpath);
		return "index";
	}
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/board")
	public String board() {
		return "Board/boardForm";
	}
	@RequestMapping(value = "/view")
	public String view() {
		return "Board/viewForm";
	}
	@RequestMapping(value = "/write")
	public String write() {
		return "Board/writeForm";
	}
	@RequestMapping(value = "/login")
	public String login() {
		return "Member/loginForm";
	}
	@RequestMapping(value = "/member")
	public String member(HttpSession session) {
		session.setAttribute("authStatus", false);
		
		return "Member/memberForm";
	}
	
}
