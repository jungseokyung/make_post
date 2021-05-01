package com.easycerti.datacenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easycerti.datacenter.dao.CommentDAO;
import com.easycerti.datacenter.model.CommentVO;

@Service( "CommentManager" )
public class CommentManagerImpl  implements CommentManager { 

	@Autowired
	CommentDAO commentDao;
	
	@Override
	public List<CommentVO> listComment(int bno) {
		// TODO Auto-generated method stub
		return commentDao.listComment(bno);
	}
	
	public void createComment(CommentVO vo) {
		String user_id = vo.getUser_id();
		String comment = vo.getComment();
		String writer = vo.getWriter();
		
		//태그문자처리 (< ==> &lt; > ==> &gt;)
		//replace(A,B) A를 B로 변경
		user_id = user_id.replace("<","&lt");
		user_id = user_id.replace("<","&gt");
		comment = comment.replace("<","&lt");
		comment = comment.replace("<","&gt");
		writer = writer.replace("<","&lt");
		writer = writer.replace("<","&gt");
		
		//공백 문자처리
		user_id = user_id.replace(" ",		"&nbsp;&nbsp;");
		writer = writer.replace(" ",		"&nbsp;&nbsp;");
		
		//줄바꿈 문자처리
		comment = comment.replace("\n", "<br>");
		
		vo.setUser_id(user_id);
		vo.setComment(comment);
		vo.setWriter(writer);
		
		commentDao.createComment(vo);
	};
	
}


