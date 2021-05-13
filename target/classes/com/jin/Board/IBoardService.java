package com.jin.Board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IBoardService {
	public void Write(Board board, HttpServletRequest request);

	public List<Board> SelectBoard();
	public Map<String, Object> DetailRead(String writeNo);

	public void REPL(Board board, HttpServletRequest request);
}
