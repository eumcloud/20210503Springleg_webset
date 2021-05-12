package com.jin.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.Membership.Login;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired private IBoardService iLoginServ;
		
	@RequestMapping(value = "write")
	public String write(Model model, HttpSession session) {
		model.addAttribute("usrId", session.getAttribute("id"));
		return "forward:/index?formpath=write";
	}
	
	@RequestMapping(value = "writeProc")
	public String writeProc(Board board, HttpServletRequest request) {
		iLoginServ.Write(board, request);
		return "forward:/index?formpath=board";
	}
}





