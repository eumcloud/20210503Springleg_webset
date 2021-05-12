package com.jin.Board;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	public int Write(Board board);
	public void AttachFile(Map<String, String> fileMap);
	public List<Board> SelectBoard();
	public List<Board> SelectContetns(int no);
	public void UpdateContetns(int no);
	public void DeleteContents(int no);
}
