package com.jin.Board;

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
	
	
	@RequestMapping (value="/BoardProc")
	public String BoardLst(Model model, Login login) {
		List<Board> BoardLst = new List<Board>();
		BoardLst =  iServ.BoardLst(login);
		
		model.addAttribute("home", "/BoardForm");
		return "index";
	}
	@RequestMapping (value="/BoardProc")
	public String InsertBoard (Model model, Board board) {
		
		iServ.InsertBoard(board);
		
		model.addAttribute("home", "BoardForm");
		return "index";
	}
}
