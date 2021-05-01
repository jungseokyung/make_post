package com.easycerti.datacenter.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.easycerti.datacenter.model.CommentVO;

@Repository( "CommentDAO" )

public class CommentDAOImpl implements CommentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	///datacenter/src/main/resources/mapper/code/board_mapper.xml
	private static final String NAMESPACE_CODE = "com.easycerti.datacenter.dao.comment_mapper";
	
	@Override
	public List<CommentVO> listComment(int bno) { //한개 게시물에 댓글 여러개.
		return sqlSession.selectList(NAMESPACE_CODE + ".readComment",bno);
	}

	@Override
	public void createComment(CommentVO vo) {
		sqlSession.insert(NAMESPACE_CODE+".createComment",vo);
	}
}
