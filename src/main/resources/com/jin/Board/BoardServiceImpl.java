package com.jin.Board;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jin.Membership.Login;
import com.jin.mail.SHA;

@Service
public class BoardServiceImpl implements IBoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired private IBoardDao iBoardDao;

	private final String UPLOADPATH = "/resources/upload/";
	
	@Override
	public void Write(Board board, HttpServletRequest request) {
		Date writedate = new Date(System.currentTimeMillis());
		board.setWritedate(writedate);
		iBoardDao.Write(board);
//		logger.warn(board.getNo()+"");
		List<Map<String, String>> fileLst = Upload(request);
		
		for(Map<String, String> fileMap : fileLst) {
			fileMap.put("fno", board.getNo().toString());
			iBoardDao.AttachFile(fileMap);
		}
	}
	private void DownloadFile(InputStream inputStream, String filePath, String fileName) {
		logger.warn(filePath+UPLOADPATH+fileName+System.currentTimeMillis());
		File file = new File(filePath+UPLOADPATH+fileName+System.currentTimeMillis());
		try {
			Files.copy(inputStream, file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private List<Map<String, String>> Upload(HttpServletRequest request) {
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multiRequest.getFileNames();
		MultipartFile multipartFile = null;
		
		List<Map<String, String>> fileLst = new ArrayList<Map<String,String>>();
		
		while(iterator.hasNext()){
			String fieldName = iterator.next();
			multipartFile = multiRequest.getFile(fieldName);
	        
			if(multipartFile.isEmpty() == false){
				Map<String, String> fileMap = new HashMap<String, String>();
				
				String originFile = multipartFile.getOriginalFilename();
				String systemFile = originFile+System.currentTimeMillis();
				fileMap.put("originFile", originFile);
				fileMap.put("systemFile", systemFile);
				
				fileLst.add(fileMap);
				//¾÷·Îµå
				String filePath = multiRequest.getSession().getServletContext().getRealPath("/");
				try {
					DownloadFile(multipartFile.getInputStream(), filePath, systemFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return fileLst;
	}
	@Override
	public List<Board> SelectBoard() {
		List<Board> boardLst= iBoardDao.SelectBoard();
		
		return boardLst;
	}
	
	
	@Override
	public Map<String, Object> DetailRead(String writeNo) {
//		List<Map<String,Object>> attachLst = iBoardDao.DeatilReadAttach(writeNo);
////		List<Board> read = iBoardDao.DetailRead(writeNo);
//		logger.warn(attachLst.size()+"");
//		for (Map<String, Object> attachMap : attachLst) {
//			for(String key : attachMap.keySet());
//				logger.warn(key +" : " + attachMap.get(key));	}
		
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("board", iBoardDao.DetailRead(writeNo));
		boardMap.put("attachLst", iBoardDao.DeatilReadAttach(writeNo));
		
	
		return boardMap;
	}
	@Override
	public void REPL(Board board, HttpServletRequest request) {
		Date writedate = new Date(System.currentTimeMillis());
		board.setWritedate(writedate);
		iBoardDao.REPL(board);
//		logger.warn(board.getNo()+"");
		List<Map<String, String>> fileLst = Upload(request);
		
		for(Map<String, String> fileMap : fileLst) {
			fileMap.put("fno", board.getNo().toString());
			iBoardDao.AttachFile(fileMap);
		}
	}
	
	
}









