package com.jin.Board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IBoardService {
	public void Write(Board board, HttpServletRequest request);
	public List<Board> SelectBoard(HttpServletRequest request);
	public Map<String, Object> DetailRead(String writeNo);
	public void Modify(Board board);
	public void Delete(String no);
	public void Deletes(String[] chkboxs);
	public String getNavi(HttpServletRequest request);
}
