package com.jin.Board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("Board")
public class WriteController {
	private static final Logger logger = LoggerFactory.getLogger(WriteController.class);
	
	@Autowired IWriteService iServ;
	
	
	@RequestMapping(value="writeForm")
	public String writeForm(Model model) {
		
		
		return "index?formpath=writeForm";
	}
	
	@RequestMapping(value="writeProc")
	public String writeProc(Model model, Board board) {
		
		Board write = iServ.writeProc(board); 
		
		
		
		
		return "forward:/index?formpath=writeForm";
	}
}
