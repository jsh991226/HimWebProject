package egovframework.shop.service;

import java.util.List;
import egovframework.shop.service.ShopDefaultVO;
import egovframework.shop.service.ShopVO;

/**
 * @Class Name : ShopService.java
 * @Description : Shop Business class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ShopService {
	
	/**
	 * shop을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ShopVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertShop(ShopVO vo) throws Exception;
    
    /**
	 * shop을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ShopVO
	 * @return void형
	 * @exception Exception
	 */
    void updateShop(ShopVO vo) throws Exception;
    
    /**
	 * shop을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ShopVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteShop(ShopVO vo) throws Exception;
    
    /**
	 * shop을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ShopVO
	 * @return 조회한 shop
	 * @exception Exception
	 */
    ShopVO selectShop(ShopVO vo) throws Exception;
    
    /**
	 * shop 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return shop 목록
	 * @exception Exception
	 */
    List selectShopList(ShopDefaultVO searchVO) throws Exception;
    
    /**
	 * shop 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return shop 총 갯수
	 * @exception
	 */
    int selectShopListTotCnt(ShopDefaultVO searchVO);
    
}
