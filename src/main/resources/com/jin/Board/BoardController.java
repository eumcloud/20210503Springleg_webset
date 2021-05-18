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

import com.care.WebPage.BoardTools;
import com.jin.Membership.Login;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired private IBoardService iBoardServ;
		
	@RequestMapping(value = "write")
	public String write(Model model, HttpSession session) {
		model.addAttribute("usrId", session.getAttribute("id"));
		model.addAttribute("btnName", "글쓰기");
		model.addAttribute("proc", "writeProc");
		return "forward:/index?formpath=write";
	}
	@RequestMapping(value = "modify")
	public String modify(Model model, HttpSession session, Board board) {
		model.addAttribute("usrId", session.getAttribute("id"));
		model.addAttribute("btnName", "수정");
		model.addAttribute("proc", "modifyProc");
		return "forward:/index?formpath=write";
	}

	@RequestMapping(value = "writeProc")
	public String writeProc(Board board, HttpServletRequest request) {
		iBoardServ.Write(board, request);
		return "forward:/board/boardProc";
	}
	@RequestMapping(value = "modifyProc")
	public String modifyProc(Board board) {
		iBoardServ.Modify(board);
		return "forward:/board/boardProc";
	}
	@RequestMapping(value = "boardProc")
	public String boardProc(Model model, HttpServletRequest request) {
		List<Board> boardLst = iBoardServ.SelectBoard(request);
		model.addAttribute("boardLst", boardLst);
		model.addAttribute("navi", iBoardServ.getNavi(request));
		
		return "forward:/index?formpath=board";
	}
//	@RequestMapping(value = "boardPage")
//	public String boardPage(Model model, HttpServletRequest request, 
//			@RequestParam int currentPage) {
//		List<Board> boardLst = iBoardServ.SelectBoard(currentPage);
//		model.addAttribute("boardLst", boardLst);
//		model.addAttribute("navi", iBoardServ.getNavi(request));
//		return "forward:/index?formpath=board";
//	}
	@RequestMapping(value = "detailRead")
	public String detailRead(Model model, @RequestParam String writeNo) {
		Map<String, Object> boardMap =  iBoardServ.DetailRead(writeNo);
		model.addAttribute("board", boardMap.get("board"));
		model.addAttribute("attachLst", boardMap.get("attachLst"));
		return "forward:/index?formpath=view";
	}
	@RequestMapping(value = "reply")
	public String reply(Model model, @RequestParam String pno, HttpSession session) {
		model.addAttribute("usrId", session.getAttribute("id"));
		model.addAttribute("btnName", "글쓰기");
		model.addAttribute("proc", "writeProc");
		
		model.addAttribute("pno", pno);
		return "forward:/index?formpath=write";
	}
	@RequestMapping(value = "delete")
	public String delete(@RequestParam String no) {
		iBoardServ.Delete(no);
		return "forward:/board/boardProc";
	}
	@RequestMapping(value = "deletes")
	public String deletes(HttpServletRequest reqeust) {
		String [] chkboxs = reqeust.getParameterValues("chkbox");
		iBoardServ.Deletes(chkboxs);
		return "forward:/board/boardProc";
	}
}





