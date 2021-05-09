package com.jin.Board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

@Controller
@RequestMapping(value="/Board")
public class BoardController {

	@Autowired
	private IBoardService iServ;
	
	
	@RequestMapping (value="BoardProc")
	public String BoardLst(Model model, Login login, Board board) {
		List<Board> BoardLst = new ArrayList<Board>();
		BoardLst =  iServ.BoardLst(board, login);
		
		model.addAttribute("boardLst", BoardLst);
		model.addAttribute("home", "/BoardForm");
		return "forward:/index?formpath=boardForm&pageNum=1";
	}
	@RequestMapping (value="writeProc")
	public String InsertBoard (Model model, Board board) {
		
		iServ.InsertBoard(board);
		return "forward:/index?formpath=writeForm";
	}
	
	@RequestMapping(value="writeProc")
	public String updateWrite(Model model, Board board, HttpSession session,Member member) {
		
		iServ.UpdateWrite(board, session, member);
		return "forward:/index?formpath=writeForm";
	}
	@RequestMapping(value="deleteProc")
	public String deleteProc(Model model, Board board, HttpSession session,Member member) {
		
		iServ.DeleteWrite(board, session, member);
		
		return "forward:/index?formpath=boardForm";
	}
}
