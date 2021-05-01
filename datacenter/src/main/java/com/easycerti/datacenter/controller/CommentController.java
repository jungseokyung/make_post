package com.easycerti.datacenter.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easycerti.datacenter.commons.DataModelAndView;
import com.easycerti.datacenter.dao.BoardDAO;
import com.easycerti.datacenter.dao.CommentDAO;
import com.easycerti.datacenter.model.BoardVO;
import com.easycerti.datacenter.model.CommentVO;
import com.easycerti.datacenter.service.CommentManager;

public class CommentController {

	@Autowired
	CommentDAO commentDao;

	@Autowired
	CommentManager commentManager;
	

//	//댓글가져오기
//	@RequestMapping(value = "/listComment", method = RequestMethod.GET)
//	public DataModelAndView listAll(@RequestParam int bno,HttpServletRequest request, Locale locale, Model model) {
//		DataModelAndView modelAndView = new DataModelAndView();
//		//int cnt=commentDao.listAllCnt();
//		List<CommentVO> list =commentManager.listComment(bno);
//		//String list=boardManager.listAll();
//		
//		modelAndView.setViewName("board/list");
//		modelAndView.addObject("list",list);
//		//System.out.println("************cnt "+cnt);
//		System.out.println("************댓글달기 "+list);
//		return modelAndView;
//	}

}
