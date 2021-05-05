package com.easycerti.datacenter.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.easycerti.datacenter.model.BoardVO;
import com.easycerti.datacenter.model.PagingVO;

@Repository( "BoardDAO" )
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	///datacenter/src/main/resources/mapper/code/board_mapper.xml
	private static final String NAMESPACE_CODE = "com.easycerti.datacenter.dao.board_mapper";
	
	@Override
	public int listAllCnt() {//단순 count 리턴
		return sqlSession.selectOne(NAMESPACE_CODE+".listAllCnt");
	}

	@Override
	public List<BoardVO> listAll(){
		return sqlSession.selectList(NAMESPACE_CODE+".listAll");
	}

	//상세보기
	@Override
	public BoardVO read(int bno) {
		return sqlSession.selectOne(NAMESPACE_CODE+".read",bno);
	}

	@Override
	public void create(BoardVO vo) {
		 sqlSession.insert(NAMESPACE_CODE+".create",vo);
	}

	@Override
	public void delete(int bno) {
		sqlSession.delete(NAMESPACE_CODE+".deleteArticle",bno);
		
	}

	@Override
	public void update(BoardVO vo) {
		sqlSession.update(NAMESPACE_CODE+".updateArticle",vo);
		
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectBoard(PagingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

//	public String listAll() {
//		return sqlSession.selectOne(NAMESPACE_CODE+".listAll");
//	}
}
