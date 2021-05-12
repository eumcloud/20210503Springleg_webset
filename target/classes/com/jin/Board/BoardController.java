package com.jin.Board;

import java.util.List;

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
	
	@RequestMapping(value = "viewForm")
	public String viewForm(Model model, Board board, HttpServletRequest request) {
		
		//1.고객이 클릭한 글의 no값을 받아온다.
		int no = board.getNo();
		
		
		//2.해당 게시글 정보 불러온다.
		List<Board> contents = iServ.SelectContetns(no);
		//3.model로 보내준다.
		
		model.addAttribute("content", contents);
		
		return "forward:/index?formpath=viewForm";
	}
	
	@RequestMapping(value="/board/")
}





