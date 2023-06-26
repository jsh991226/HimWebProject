package egovframework.notify.web;

import java.util.ArrayList;
import java.util.Date;
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

import com.ibm.icu.text.SimpleDateFormat;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.notify.service.NotifyService;
import egovframework.notify.service.NotifyDefaultVO;
import egovframework.notify.service.NotifyVO;

/**
 * @Class Name : NotifyController.java
 * @Description : Notify Controller class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=NotifyVO.class)
public class NotifyController {

    @Resource(name = "notifyService")
    private NotifyService notifyService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * notify 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 NotifyDefaultVO
	 * @return "/notify/NotifyList"
	 * @exception Exception
	 */
    @RequestMapping(value="/notify/NotifyList.do")
    public String selectNotifyList(@ModelAttribute("searchVO") NotifyDefaultVO searchVO, 
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
		
        List<?> notifyList = notifyService.selectNotifyList(searchVO);
        model.addAttribute("resultList", notifyList);
        
        int totCnt = notifyService.selectNotifyListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/notify/NotifyList";
    } 
    @RequestMapping(value="/notify/GetAllList.do")
    public String GetAllList(HttpServletRequest request, @ModelAttribute("searchVO") NotifyDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {

		
        List<?> notifyList = notifyService.selectNotifyList(searchVO);
        model.addAttribute("notifyList", notifyList);
		request.getSession().setAttribute("notifyList", notifyList);
        return "redirect:/notifyList.jsp";
    } 
    
    @RequestMapping(value="/notify/MainList.do")
    public @ResponseBody List<NotifyVO> MainList(@ModelAttribute("searchVO") NotifyDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
        List<NotifyVO> notifyList = notifyService.selectNotifyList(searchVO);
        ArrayList<NotifyVO> _notify = new ArrayList<NotifyVO>();
        for (int i = 0 ; i < notifyList.size() ; i++) {
        	_notify.add(notifyList.get(i));
        	if (i >= 3) break;
        }
        return _notify;
    } 
    
    @RequestMapping("/notify/addNotifyView.do")
    public String addNotifyView(
            @ModelAttribute("searchVO") NotifyDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("notifyVO", new NotifyVO());
        return "/notify/NotifyRegister";
    }
    
    @RequestMapping("/notify/addNotify.do")
    public String addNotify(
            NotifyVO notifyVO,
            @ModelAttribute("searchVO") NotifyDefaultVO searchVO, SessionStatus status)
            throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String nowTime = sdf2.format(now);
		notifyVO.setRegdate(nowTime);
        notifyService.insertNotify(notifyVO);
        status.setComplete();
		return "redirect:/index.jsp";
    }
    
	/*
	 * @RequestMapping("/notify/updateNotifyView.do") public String
	 * updateNotifyView(
	 * 
	 * @RequestParam("id") int id ,
	 * 
	 * @ModelAttribute("searchVO") NotifyDefaultVO searchVO, Model model) throws
	 * Exception { NotifyVO notifyVO = new NotifyVO(); notifyVO.setId(id); // 변수명은
	 * CoC 에 따라 notifyVO model.addAttribute(selectNotify(notifyVO, searchVO));
	 * return "/notify/NotifyRegister"; }
	 */
    @RequestMapping("/notify/selectNotify.do")
    public String selectNotify(
    		HttpServletRequest request,NotifyVO notifyVO,
            @ModelAttribute("searchVO") NotifyDefaultVO searchVO,ModelMap model) throws Exception {
		int notifyID = Integer.parseInt(request.getParameter("notifyID"));
		notifyVO.setId(notifyID);
        model.addAttribute("NotifyVO", notifyService.selectNotify(notifyVO));

		return "redirect:/notifyView.jsp";
    }

    @RequestMapping("/notify/updateNotify.do")
    public String updateNotify(
            NotifyVO notifyVO,
            @ModelAttribute("searchVO") NotifyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        notifyService.updateNotify(notifyVO);
        status.setComplete();
        return "forward:/notify/NotifyList.do";
    }
    
    @RequestMapping("/notify/deleteNotify.do")
    public String deleteNotify(
            NotifyVO notifyVO,
            @ModelAttribute("searchVO") NotifyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        notifyService.deleteNotify(notifyVO);
        status.setComplete();
        return "forward:/notify/NotifyList.do";
    }

}
