package egovframework.itemdata.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.itemdata.service.PostitemService;
import egovframework.itemdata.service.PostitemDefaultVO;
import egovframework.itemdata.service.PostitemVO;

/**
 * @Class Name : PostitemController.java
 * @Description : Postitem Controller class
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
@SessionAttributes(types=PostitemVO.class)
public class PostitemController {

    @Resource(name = "postitemService")
    private PostitemService postitemService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * postitem 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 PostitemDefaultVO
	 * @return "/postitem/PostitemList"
	 * @exception Exception
	 */
    @RequestMapping(value="/postitem/PostitemList.do")
    public String selectPostitemList(@ModelAttribute("searchVO") PostitemDefaultVO searchVO, 
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
		
        List<?> postitemList = postitemService.selectPostitemList(searchVO);
        model.addAttribute("resultList", postitemList);
        
        int totCnt = postitemService.selectPostitemListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/postitem/PostitemList";
    } 
    
    @RequestMapping(value="/postitem/getPostItem.do")
    @ResponseBody
    public String getPostItem(HttpServletRequest request,PostitemVO vo) throws Exception {
    	
		vo.setFirstIndex(0); //offset 변경
		String id = request.getParameter("owner");
		vo.setOwnerid(id);
        List<PostitemVO> postList = postitemService.selectPostitemListAll(vo);
        String _temp = "";
        updateViewItemVaild(vo);
        for(int i = 0 ; i < postList.size() ; i++) _temp = _temp+"/"+postList.get(i).getItemdataname()+"-"+postList.get(i).getId();
        if (postList.size() < 1 ) _temp = "null";
    	return _temp;
    }
    
    @RequestMapping("/postitem/updateViewItemVaild.do")
    @ResponseBody
    public void updateViewItemVaild(
            PostitemVO postitemVO) throws Exception {
    	try{
            postitemService.updatePostitem(postitemVO);
    	}catch(Exception e) {
    		
    	}
    	return;
    }
    

    
    @RequestMapping(value="/postitem/getNewPost.do")
    @ResponseBody
    public String getNewPost(HttpServletRequest request,PostitemVO vo) throws Exception {
    	
		vo.setFirstIndex(0); //offset 변경
		String id = request.getParameter("owner");
		vo.setOwnerid(id);
        List<PostitemVO> postList = postitemService.selectPostitemList(vo);
        updateViewItemVaild(vo);
        if (postList.size() > 0) return "*/$@1*/$@";
    	return "*/$@0*/$@";
    }
    
    
    @RequestMapping("/postitem/addPostitemView.do")
    public String addPostitemView(
            @ModelAttribute("searchVO") PostitemDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("postitemVO", new PostitemVO());
        return "/postitem/PostitemRegister";
    }
    
    @RequestMapping("/postitem/addPostitem.do")
    public String addPostitem(
            PostitemVO postitemVO,
            @ModelAttribute("searchVO") PostitemDefaultVO searchVO, SessionStatus status)
            throws Exception {
        postitemService.insertPostitem(postitemVO);
        status.setComplete();
        return "forward:/postitem/PostitemList.do";
    }
    
    @RequestMapping("/postitem/updatePostitemView.do")
    public String updatePostitemView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") PostitemDefaultVO searchVO, Model model)
            throws Exception {
        PostitemVO postitemVO = new PostitemVO();
        postitemVO.setId(id);        
        // 변수명은 CoC 에 따라 postitemVO
        model.addAttribute(selectPostitem(postitemVO, searchVO));
        return "/postitem/PostitemRegister";
    }

    @RequestMapping("/postitem/selectPostitem.do")
    public @ModelAttribute("postitemVO")
    PostitemVO selectPostitem(
            PostitemVO postitemVO,
            @ModelAttribute("searchVO") PostitemDefaultVO searchVO) throws Exception {
        return postitemService.selectPostitem(postitemVO);
    }

    @RequestMapping("/postitem/updatePostitem.do")
    public String updatePostitem(
            PostitemVO postitemVO,
            @ModelAttribute("searchVO") PostitemDefaultVO searchVO, SessionStatus status)
            throws Exception {
        postitemService.updatePostitem(postitemVO);
        status.setComplete();
        return "forward:/postitem/PostitemList.do";
    }
    
    @RequestMapping("/postitem/deletePostitem.do")
    public String deletePostitem(
            PostitemVO postitemVO,
            @ModelAttribute("searchVO") PostitemDefaultVO searchVO, SessionStatus status)
            throws Exception {
        postitemService.deletePostitem(postitemVO);
        status.setComplete();
        return "forward:/postitem/PostitemList.do";
    }

}
