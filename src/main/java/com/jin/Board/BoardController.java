package com.jin.Board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jin.Membership.Login;

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
		return "index";
	}
	@RequestMapping (value="writeProc")
	public String InsertBoard (Model model, Board board) {
		
		iServ.InsertBoard(board);
		return "index";
	}
	
	@RequestMapping(value="writeProc")
	public String updateWrite(Model model, Board board) {
		
		iServ.UpdateWrite(board);
		return "index";
	}
}
