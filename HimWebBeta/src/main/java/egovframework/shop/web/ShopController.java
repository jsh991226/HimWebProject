package egovframework.shop.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import egovframework.shop.service.ShopService;
import egovframework.shop.service.ShopDefaultVO;
import egovframework.shop.service.ShopVO;

/**
 * @Class Name : ShopController.java
 * @Description : Shop Controller class
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
@SessionAttributes(types=ShopVO.class)
public class ShopController {

    @Resource(name = "shopService")
    private ShopService shopService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * shop 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ShopDefaultVO
	 * @return "/shop/ShopList"
	 * @exception Exception
	 */
    @RequestMapping(value="/shop/ShopList.do")
    public String selectShopList(@ModelAttribute("searchVO") ShopDefaultVO searchVO, 
    		ModelMap model, HttpServletRequest request)
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
		
        List<?> shopList = shopService.selectShopList(searchVO);
        model.addAttribute("shopList", shopList);
    	HttpSession session = request.getSession();
    	session.setAttribute("shopList", shopList);
        
        int totCnt = shopService.selectShopListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
    	return "redirect:/shop.jsp";
    } 
    
    @RequestMapping("/shop/addShopView.do")
    public String addShopView(
            @ModelAttribute("searchVO") ShopDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("shopVO", new ShopVO());
        return "/shop/ShopRegister";
    }
    
    @RequestMapping("/shop/addShop.do")
    public String addShop(
            ShopVO shopVO,
            @ModelAttribute("searchVO") ShopDefaultVO searchVO, SessionStatus status)
            throws Exception {
        shopService.insertShop(shopVO);
        status.setComplete();
        return "forward:/shop/ShopList.do";
    }
    
	/*
	 * @RequestMapping("/shop/updateShopView.do") public String updateShopView(
	 * 
	 * @RequestParam("id") int id ,
	 * 
	 * @ModelAttribute("searchVO") ShopDefaultVO searchVO, Model model) throws
	 * Exception { ShopVO shopVO = new ShopVO(); shopVO.setId(id); // 변수명은 CoC 에 따라
	 * shopVO model.addAttribute(selectShop(shopVO, searchVO)); return
	 * "/shop/ShopRegister"; }
	 */

    @RequestMapping("/shop/selectShop.do")
    @ResponseBody
    public ModelAndView selectShop(ShopVO shopVO,@ModelAttribute("searchVO") ShopDefaultVO searchVO, HttpServletRequest request) throws Exception {
		String id = request.getParameter("owner");
		String desc;
		shopVO.setId(Integer.parseInt(id));
		ShopVO _result = shopService.selectShop(shopVO);
    	ModelAndView jsonView = new ModelAndView("jsonView");
    	jsonView.addObject("result",_result);
        return jsonView;
    }

    @RequestMapping("/shop/updateShop.do")
    public String updateShop(
            ShopVO shopVO,
            @ModelAttribute("searchVO") ShopDefaultVO searchVO, SessionStatus status)
            throws Exception {
        shopService.updateShop(shopVO);
        status.setComplete();
        return "forward:/shop/ShopList.do";
    }
    
    @RequestMapping("/shop/deleteShop.do")
    public String deleteShop(
            ShopVO shopVO,
            @ModelAttribute("searchVO") ShopDefaultVO searchVO, SessionStatus status)
            throws Exception {
        shopService.deleteShop(shopVO);
        status.setComplete();
        return "forward:/shop/ShopList.do";
    }

}
