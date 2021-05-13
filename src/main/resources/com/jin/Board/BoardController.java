package com.jin.Board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.Membership.Login;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired private IBoardService iServ;
	
	@RequestMapping(value = "write")
	public String write(Model model, HttpSession session) {
		model.addAttribute("usrId", session.getAttribute("id"));
		return "forward:/index?formpath=write";
	}
	
	@RequestMapping(value = "writeProc")
	public String writeProc(Board board, HttpServletRequest request) {
		iServ.Write(board, request);
		return "forward:/index?formpath=board";
	}
	
	@RequestMapping(value = "boardProc")
	public String boardProc(Model model, Board board, HttpServletRequest request) {
		
		List<Board> boardLst = iServ.SelectBoard();
		model.addAttribute("boardLst", boardLst);
		// writedate오류 jsp에서는 문자로 변환해서 썼지만, mybatis에서는 그대로 불러와야함.   
		
		return "forward:/index?formpath=boardForm";
	}
	
	

	@RequestMapping(value="detailRead")
	public String detailRead(Model model, @RequestParam String writeNo) {
		logger.warn(writeNo);
		
		Map<String, Object> boardMap = iServ.DetailRead(writeNo);
		
		model.addAttribute("board", boardMap.get("board"));
		model.addAttribute("attachLst", boardMap.get("attachLst"));
		
		return "forward:/index?formapth=viewForm";
	}
	@RequestMapping(value="reply")
	public String reply(Model model, Login login) {
		
		model.addAttribute("usrId", login.getId());
		return "forward:/index?formpath=writeForm";
	}
	@RequestMapping(value="replyProc")
	public String replyProc(Board board, HttpServletRequest request) {
		
		iServ.REPL(board, request);		
		return "forward:/index?formpath=boardProc";
	}
	
	
}





