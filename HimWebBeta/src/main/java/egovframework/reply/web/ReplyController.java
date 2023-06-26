package egovframework.reply.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ibm.icu.text.SimpleDateFormat;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.reply.service.ReplyService;
import egovframework.reply.service.ReplyDefaultVO;
import egovframework.reply.service.ReplyVO;

/**
 * @Class Name : ReplyController.java
 * @Description : Reply Controller class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=ReplyVO.class)
public class ReplyController {

    @Resource(name = "replyService")
    private ReplyService replyService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * reply 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ReplyDefaultVO
	 * @return "/reply/ReplyList"
	 * @exception Exception
	 */
    @RequestMapping(value="/reply/ReplyList.do")
    public String selectReplyList(@ModelAttribute("searchVO") ReplyDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> replyList = replyService.selectReplyList(searchVO);
        model.addAttribute("resultList", replyList);
        
        int totCnt = replyService.selectReplyListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/reply/ReplyList";
    } 
    @RequestMapping(value="/reply/getReplyList.do")
    public @ResponseBody List<ReplyVO> getReplyList(@RequestParam("boardid") String boardid,ModelMap model)
            throws Exception {

    	ReplyVO searchVO = new ReplyVO();
    	searchVO.setBoardid(Integer.parseInt(boardid));
        List<ReplyVO> replyList = replyService.selectReplyList(searchVO);
        return replyList;
    } 
    
    
    @RequestMapping("/reply/addReplyView.do")
    public String addReplyView(
            @ModelAttribute("searchVO") ReplyDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("replyVO", new ReplyVO());
        return "/reply/ReplyRegister";
    }
    
    @RequestMapping("/reply/addReply.do")
    public String addReply(
            ReplyVO replyVO,
            @ModelAttribute("searchVO") ReplyDefaultVO searchVO, SessionStatus status)
            throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String nowTime = sdf2.format(now);
    	replyVO.setRegdate(nowTime);
    	System.out.println("Write Time : " +nowTime);
        replyService.insertReply(replyVO);
        status.setComplete();
        return "redirect:/notifyView.jsp";
    }
    
    @RequestMapping("/reply/updateReplyView.do")
    public String updateReplyView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") ReplyDefaultVO searchVO, Model model)
            throws Exception {
        ReplyVO replyVO = new ReplyVO();
        replyVO.setId(id);
        // 변수명은 CoC 에 따라 replyVO
        model.addAttribute(selectReply(replyVO, searchVO));
        return "/reply/ReplyRegister";
    }

    @RequestMapping("/reply/selectReply.do")
    public @ModelAttribute("replyVO")
    ReplyVO selectReply(
            ReplyVO replyVO,
            @ModelAttribute("searchVO") ReplyDefaultVO searchVO) throws Exception {
        return replyService.selectReply(replyVO);
    }

    @RequestMapping("/reply/updateReply.do")
    public String updateReply(
            ReplyVO replyVO,
            @ModelAttribute("searchVO") ReplyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        replyService.updateReply(replyVO);
        status.setComplete();
        return "forward:/reply/ReplyList.do";
    }
    
    @RequestMapping("/reply/deleteReply.do")
    public String deleteReply(
            ReplyVO replyVO,
            @ModelAttribute("searchVO") ReplyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        replyService.deleteReply(replyVO);
        status.setComplete();
        return "forward:/reply/ReplyList.do";
    }

}
