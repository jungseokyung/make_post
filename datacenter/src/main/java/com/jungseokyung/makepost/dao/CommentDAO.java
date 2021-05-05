package com.jungseokyung.makepost.dao;

import java.util.List;

import com.jungseokyung.makepost.model.CommentVO;

public interface CommentDAO {
//controller에 있는 함수와 연결 

	public List<CommentVO> listComment(int bno);
	
	public void createComment(CommentVO vo);
}

