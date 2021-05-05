package com.jungseokyung.makepost.service;

import java.util.List;

import com.jungseokyung.makepost.model.CommentVO;

public interface CommentManager {
	
	public List<CommentVO> listComment(int bno);

	public void createComment(CommentVO vo);
}
