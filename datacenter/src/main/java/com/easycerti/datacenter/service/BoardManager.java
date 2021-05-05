package com.easycerti.datacenter.service;

import java.util.List;

import com.easycerti.datacenter.model.BoardVO;
import com.easycerti.datacenter.model.PagingVO;

public interface BoardManager {//Servivce
	
	public int listAllCnt();
	
//	public String listAll();
	public List<BoardVO> listAll();

	public BoardVO read(int bno);
	
	public void create(BoardVO vo);

	public void delete(int bno);

	public void update(BoardVO vo);
	
	/*페이징 처리*/
	
	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<BoardVO> selectBoard(PagingVO vo);
}
