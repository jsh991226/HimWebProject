package egovframework.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.shop.service.ShopService;
import egovframework.shop.service.ShopDefaultVO;
import egovframework.shop.service.ShopVO;
import egovframework.shop.service.impl.ShopMapper;
/**
 * @Class Name : ShopServiceImpl.java
 * @Description : Shop Business Implement class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("shopService")
public class ShopServiceImpl extends EgovAbstractServiceImpl implements
        ShopService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Resource(name="shopMapper")
    private ShopMapper shopDAO;
    
    //@Resource(name="shopDAO")
    //private ShopDAO shopDAO;
    
    /** ID Generation */
    //@Resource(name="{egovShopIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * shop을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ShopVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertShop(ShopVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	shopDAO.insertShop(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * shop을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ShopVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateShop(ShopVO vo) throws Exception {
        shopDAO.updateShop(vo);
    }

    /**
	 * shop을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ShopVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteShop(ShopVO vo) throws Exception {
        shopDAO.deleteShop(vo);
    }

    /**
	 * shop을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ShopVO
	 * @return 조회한 shop
	 * @exception Exception
	 */
    public ShopVO selectShop(ShopVO vo) throws Exception {
        ShopVO resultVO = shopDAO.selectShop(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * shop 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return shop 목록
	 * @exception Exception
	 */
    public List<?> selectShopList(ShopDefaultVO searchVO) throws Exception {
        return shopDAO.selectShopList(searchVO);
    }

    /**
	 * shop 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return shop 총 갯수
	 * @exception
	 */
    public int selectShopListTotCnt(ShopDefaultVO searchVO) {
		return shopDAO.selectShopListTotCnt(searchVO);
	}
    
}
