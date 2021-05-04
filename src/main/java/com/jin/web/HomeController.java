package com.jin.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private Map<String, String> pathMap;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public HomeController() {
		pathMap = new HashMap<String, String>();
		pathMap.put("home", "/");
		pathMap.put("login", "/member/");
		pathMap.put("membership", "/member/");
		pathMap.put("boardForm", "/Board/");
		pathMap.put("viewForm", "/Board/");
		pathMap.put("writeForm", "/Board/");
	}

	
	@RequestMapping(value = "/{pathName}")
	public String home(@PathVariable String pathName) {

		return pathMap.get(pathName) + pathName;
	}
	@RequestMapping(value = {"/", "/home"})
	public String home() {
		
		return "index";
	}
	
}
