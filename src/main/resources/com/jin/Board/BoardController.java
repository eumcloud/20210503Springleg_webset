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
		// writedate���� jsp������ ���ڷ� ��ȯ�ؼ� ������, mybatis������ �״�� �ҷ��;���.   
		
		return "forward:/index?formpath=boardForm";
	}
	
	@RequestMapping(value = "viewForm")
	public String viewForm(Model model, Board board, HttpServletRequest request) {
		
		//1.���� Ŭ���� ���� no���� �޾ƿ´�.
		int no = board.getNo();
		
		
		//2.�ش� �Խñ� ���� �ҷ��´�.
		List<Board> contents = iServ.SelectContetns(no);
		//3.model�� �����ش�.
		
		model.addAttribute("content", contents);
		
		return "forward:/index?formpath=viewForm";
	}
	
	@RequestMapping(value="/board/")
}





