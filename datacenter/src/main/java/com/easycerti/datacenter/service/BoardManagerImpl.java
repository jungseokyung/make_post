package com.easycerti.datacenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easycerti.datacenter.dao.BoardDAO;
import com.easycerti.datacenter.model.BoardVO;
import com.easycerti.datacenter.model.PagingVO;

@Service( "BoardManager" )
public class BoardManagerImpl implements BoardManager {//ServivceImpl
	
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public int listAllCnt() {
		return boardDao.listAllCnt();
	}

	@Override
	public List<BoardVO> listAll() {
		
		return boardDao.listAll();
	}

	@Override
	public BoardVO read(int bno) {
		return boardDao.read(bno);
	}

	//게시글쓰기
	@Override
	public void create(BoardVO vo) {
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		
		//태그문자처리 (< ==> &lt; > ==> &gt;)
		//replace(A,B) A를 B로 변경
		title = title.replace("<","&lt");
		title = title.replace("<","&gt");
		writer = writer.replace("<","&lt");
		writer = writer.replace("<","&gt");
		
		//공백 문자처리
		title = title.replace(" ",		"&nbsp;&nbsp;");
		writer = writer.replace(" ",		"&nbsp;&nbsp;");
		
		//줄바꿈 문자처리
		content = content.replace("\n", "<br>");
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		boardDao.create(vo);
	}

	@Override
	public void delete(int bno) {
		boardDao.delete(bno);
		
	}

	@Override
	public void update(BoardVO vo) {
		boardDao.update(vo);
		
	}

//	@Override
//	public String listAll() {
//		return boardDao.listAll();
//	}
	
	@Override
	public int countBoard() {
		return boardDao.countBoard();
	}

	@Override
	public List<BoardVO> selectBoard(PagingVO vo) {
		return boardDao.selectBoard(vo);
	}
}
