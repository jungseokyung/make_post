package com.easycerti.datacenter.dao;

import java.util.List;

import com.easycerti.datacenter.model.CommentVO;

public interface CommentDAO {
//controller에 있는 함수와 연결 

	public List<CommentVO> listComment(int bno);
	
	public void createComment(CommentVO vo);
}

