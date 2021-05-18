package com.jin.Board;

import java.util.List;
import java.util.Map;

public interface IBoardDao {
	public int Write(Board board);
	public void AttachFile(Map<String, String> fileMap);
	public List<Board> SelectBoard(Map<String, Object> boardMap);
	public Board DetailRead(String writeNo);
	public List<Map<String, Object>> DetailReadAttach(String writeNo);
	public void InsertReply(Map<String, Integer> replyMap);
	public void Modify(Board board);
	public void Hits(Map<String, Integer> hitsMap);
	public void Delete(String no);
	public int BoardCount(Map<String, Object> boardMap);
}
