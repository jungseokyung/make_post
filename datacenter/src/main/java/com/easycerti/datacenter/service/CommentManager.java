package com.easycerti.datacenter.service;

import java.util.List;

import com.easycerti.datacenter.model.CommentVO;

public interface CommentManager {
	
	public List<CommentVO> listComment(int bno);

	public void createComment(CommentVO vo);
}
