package com.jungseokyung.makepost.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jungseokyung.makepost.commons.DataModelAndView;
import com.jungseokyung.makepost.dao.BoardDAO;
import com.jungseokyung.makepost.model.BoardVO;
import com.jungseokyung.makepost.model.CommentVO;
import com.jungseokyung.makepost.service.BoardManager;
import com.jungseokyung.makepost.service.CommentManager;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/board/*")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BoardDAO boardDao;
	
	@Autowired
	BoardManager boardManager;
	
	@Autowired
	CommentManager commentManager;
	
	//게시글 목록화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public DataModelAndView listAll(HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		int cnt=boardDao.listAllCnt();
		List<BoardVO> list =boardManager.listAll();
		//String list=boardManager.listAll();
		
		modelAndView.setViewName("board/list");
		modelAndView.addObject("list",list);
		System.out.println("************cnt "+cnt);
		System.out.println("************list "+list);
		return modelAndView;
	}
	
	//게시글 상세화면
	@RequestMapping(value = "/board/view", method = RequestMethod.GET)
	public DataModelAndView view(@RequestParam int bno,HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		System.out.println("*********MAV");
		//@RequestParam int bno,
		modelAndView.addObject("dto",boardManager.read(bno));
		System.out.println("***********DTO");
		modelAndView.setViewName("board/view");
		
		//댓글 출력
		List<CommentVO> replyList =commentManager.listComment(bno);
		//String list=boardManager.listAll();
		System.out.println("************댓글가져오기 "+replyList);
//		modelAndView.setViewName("board/list");
		modelAndView.addObject("replyList",replyList);

		return modelAndView;
	}
	
	//게시글 작성화면
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public DataModelAndView write(HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		modelAndView.setViewName("board/write");
		return modelAndView;
	}
	
	//게시글 작성처리
	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public DataModelAndView insert(@ModelAttribute BoardVO vo,HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		System.out.println("*********insert 게시글 작성처리");
		boardManager.create(vo);
		System.out.println(vo);
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	//게시글 삭제처리
	@RequestMapping(value = "/board/delete") //, method = RequestMethod.POST
	public DataModelAndView delete(@RequestParam int bno, @ModelAttribute BoardVO vo,HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		System.out.println("*********delete 게시글 삭제처리");
		boardManager.delete(bno);
		
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	//게시글 수정
	@RequestMapping(value = "/board/update", method = RequestMethod.POST) 
	public DataModelAndView update(@ModelAttribute BoardVO vo,HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		System.out.println("*********update 게시글  수정처리");
		boardManager.update(vo);
		
		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}
	
	 /**
     * 댓글 등록(Ajax)
     * @param boardVO
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/addComment.do")
    @ResponseBody
    public String ajax_addComment(@ModelAttribute("commentVO") CommentVO commentVO, HttpServletRequest request) throws Exception{
        
        HttpSession session = request.getSession();
        //LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
        
        try{
        
//        	commentVO.setWriter(loginVO.getUser_id());        
        	commentManager.createComment(commentVO);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return "success";
    }
	
	//댓글작성
	@RequestMapping(value = "/board/createComment", method = RequestMethod.POST)
	public DataModelAndView createComment(@RequestParam CommentVO vo,HttpServletRequest request, Locale locale, Model model) {
		DataModelAndView modelAndView = new DataModelAndView();
		commentManager.createComment(vo);
		
		modelAndView.setViewName("redirect:/board/view");
		System.out.println("************댓글달기 "+vo);
//		logger.info("댓글 달기!!!logger");
		return modelAndView;
	}


    /**
     * 게시물 댓글 불러오기(Ajax)
     * @param boardVO
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/board/commentList.do", produces="application/json; charset=utf8")
    @ResponseBody
    public ResponseEntity ajax_commentList(@ModelAttribute CommentVO vo,@RequestParam int bno, HttpServletRequest request) throws Exception{
        
        HttpHeaders responseHeaders = new HttpHeaders();
        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
        
        // 해당 게시물 댓글
        List<CommentVO> commentVO = commentManager.listComment(bno);
        
        if(commentVO.size() > 0){
            for(int i=0; i<commentVO.size(); i++){
                HashMap hm = new HashMap();
                hm.put("bno", commentVO.get(i).getBno());
                hm.put("comment", commentVO.get(i).getComment());
                hm.put("writer", commentVO.get(i).getWriter());
                hm.put("user_id", commentVO.get(i).getUser_id());
                hm.put("regdate", commentVO.get(i).getRegdate());
                
                hmlist.add(hm);
            }
            
        }
        
        JSONArray json = new JSONArray(hmlist);        
        return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
        
    }
}

