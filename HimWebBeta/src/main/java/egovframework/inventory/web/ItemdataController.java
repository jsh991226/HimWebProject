package egovframework.inventory.web;

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

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.inventory.service.ItemdataService;
import egovframework.inventory.service.ItemdataDefaultVO;
import egovframework.inventory.service.ItemdataVO;

/**
 * @Class Name : ItemdataController.java
 * @Description : Itemdata Controller class
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
@SessionAttributes(types=ItemdataVO.class)
public class ItemdataController {

    @Resource(name = "itemdataService")
    private ItemdataService itemdataService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * itemdata 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ItemdataDefaultVO
	 * @return "/itemdata/ItemdataList"
	 * @exception Exception
	 */
    @RequestMapping(value="/itemdata/itemDataNameList.do")
    public @ResponseBody String[] itemDataNameList(HttpServletRequest request,@ModelAttribute("searchVO") ItemdataDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	ItemdataVO dataVO = new ItemdataVO();
		String userid = request.getParameter("userid");
    	dataVO.setOwnerid(userid);
        List<ItemdataVO> itemdataList = itemdataService.selectItemdataList(dataVO);
        String[] _listName = new String[itemdataList.size()];
        for(int i = 0 ; i < itemdataList.size() ; i++) {
        	_listName[i] = itemdataList.get(i).getSprite();
        }
        
        return _listName;
    } 
    
    
    @RequestMapping(value="/itemdata/ItemdataList.do")
    public String selectItemdataList(@ModelAttribute("searchVO") ItemdataDefaultVO searchVO, 
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
		
        List<?> itemdataList = itemdataService.selectItemdataList(searchVO);
        model.addAttribute("resultList", itemdataList);
        
        int totCnt = itemdataService.selectItemdataListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/itemdata/ItemdataList";
    } 
    
    @RequestMapping("/itemdata/addItemdataView.do")
    public String addItemdataView(
            @ModelAttribute("searchVO") ItemdataDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("itemdataVO", new ItemdataVO());
        return "/itemdata/ItemdataRegister";
    }
    
    @RequestMapping("/itemdata/addItemdata.do")
    public String addItemdata(
            ItemdataVO itemdataVO,
            @ModelAttribute("searchVO") ItemdataDefaultVO searchVO, SessionStatus status)
            throws Exception {
        itemdataService.insertItemdata(itemdataVO);
        status.setComplete();
        return "forward:/itemdata/ItemdataList.do";
    }
    
    @RequestMapping("/itemdata/updateItemdataView.do")
    public String updateItemdataView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") ItemdataDefaultVO searchVO, Model model)
            throws Exception {
        ItemdataVO itemdataVO = new ItemdataVO();
        itemdataVO.setId(id);        
        // 변수명은 CoC 에 따라 itemdataVO
        model.addAttribute(selectItemdata(itemdataVO, searchVO));
        return "/itemdata/ItemdataRegister";
    }

    @RequestMapping("/itemdata/selectItemdata.do")
    public @ModelAttribute("itemdataVO")
    ItemdataVO selectItemdata(
            ItemdataVO itemdataVO,
            @ModelAttribute("searchVO") ItemdataDefaultVO searchVO) throws Exception {
        return itemdataService.selectItemdata(itemdataVO);
    }

    @RequestMapping("/itemdata/updateItemdata.do")
    public String updateItemdata(
            ItemdataVO itemdataVO,
            @ModelAttribute("searchVO") ItemdataDefaultVO searchVO, SessionStatus status)
            throws Exception {
        itemdataService.updateItemdata(itemdataVO);
        status.setComplete();
        return "forward:/itemdata/ItemdataList.do";
    }
    
    @RequestMapping("/itemdata/deleteItemdata.do")
    public String deleteItemdata(
            ItemdataVO itemdataVO,
            @ModelAttribute("searchVO") ItemdataDefaultVO searchVO, SessionStatus status)
            throws Exception {
        itemdataService.deleteItemdata(itemdataVO);
        status.setComplete();
        return "forward:/itemdata/ItemdataList.do";
    }

}
