package com.jin.Board;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jin.Membership.Login;
import com.jin.Membership.Member;

@Service
public class BoardServiceImpl implements IBoardService{
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	
	@Autowired private IBoardDao iDao;
	private List<Board> BoardLst;
	
	private final String FILEPATH = "/resources/upload/";
	

	@Override
	public List<Board> BoardLst(Board board, Login login) {
		
		iDao.SelectBoard(login);
		return BoardLst;
	}
	
	@Override
	public void write(Board board){
		iDao.InsertBoard(board);
	}
	
	
	
	@Override
	public boolean DeleteWrite(Board board, HttpSession session,Member member) {
		//������ ���ϴ� ���� �α���id�� ������쿡 ����
		
		String id = (String) session.getAttribute(member.getId());
		String idchk = iDao.SelectBoardId(board);
		if(id.contentEquals(idchk)){iDao.DeleteWrite(board); return true;}
		
		
		return false;
	}
	
	private void DownloadFile(InputStream inputStream,String filePath, String fileName) {
		File file = new File(filePath+FILEPATH+fileName+System.currentTimeMillis()); // file�ȿ� ���ڰ����� ����fileName 
		try {
			Files.copy(inputStream, file.toPath());//inputStream : �귯���� ������ ������ = �Է¹��� ������
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
	private void Upload(HttpServletRequest request) {
		      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
		      Iterator<String> iterator = multiRequest.getFileNames(); //form���� ���޹޴� ����
		      MultipartFile multipartFile = null;
		      logger.warn("Upload");
		      while(iterator.hasNext()){
		         String fieldName = iterator.next();
		         logger.warn("fieldName : "+fieldName);
		         multipartFile = multiRequest.getFile(fieldName);
		           
		         if(multipartFile.isEmpty() == false){
		            logger.warn("------------- file start -------------");
		            logger.warn("name : "+multipartFile.getName());
		            try {
		               logger.warn("filename : "+multipartFile.getOriginalFilename()); //�̸� xml���ڵ� �Ǿ ��������.
		               logger.warn("filename : "+new String(multipartFile.getOriginalFilename().getBytes("8859_1"), "UTF-8")); //���ڵ� �������� �����ٸ�.
		            } catch (UnsupportedEncodingException e) {
		               e.printStackTrace();
		            }
		            logger.warn("size : "+multipartFile.getSize()+"byte");
		            logger.warn("-------------- file end --------------\n");
		         }
		            try {
		            	String filePath= multiRequest.getSession().getServletContext().getRealPath("/");
		            	logger.warn(filePath);
		            DownloadFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), filePath);
		            }catch(IOException e){
		            	e.printStackTrace();
		            }
		            
		         }
		      }

	

	

		   


}
