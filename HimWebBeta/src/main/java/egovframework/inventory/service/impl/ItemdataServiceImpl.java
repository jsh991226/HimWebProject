package egovframework.inventory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.inventory.service.ItemdataService;
import egovframework.inventory.service.ItemdataDefaultVO;
import egovframework.inventory.service.ItemdataVO;
import egovframework.inventory.service.impl.ItemdataMapper;
/**
 * @Class Name : ItemdataServiceImpl.java
 * @Description : Itemdata Business Implement class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("itemdataService")
public class ItemdataServiceImpl extends EgovAbstractServiceImpl implements
        ItemdataService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemdataServiceImpl.class);

    @Resource(name="itemdataMapper")
    private ItemdataMapper itemdataDAO;
    
    //@Resource(name="itemdataDAO")
    //private ItemdataDAO itemdataDAO;
    
    /** ID Generation */
    //@Resource(name="{egovItemdataIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * itemdata을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ItemdataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertItemdata(ItemdataVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	itemdataDAO.insertItemdata(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * itemdata을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ItemdataVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateItemdata(ItemdataVO vo) throws Exception {
        itemdataDAO.updateItemdata(vo);
    }

    /**
	 * itemdata을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ItemdataVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteItemdata(ItemdataVO vo) throws Exception {
        itemdataDAO.deleteItemdata(vo);
    }

    /**
	 * itemdata을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ItemdataVO
	 * @return 조회한 itemdata
	 * @exception Exception
	 */
    public ItemdataVO selectItemdata(ItemdataVO vo) throws Exception {
        ItemdataVO resultVO = itemdataDAO.selectItemdata(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * itemdata 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return itemdata 목록
	 * @exception Exception
	 */
    public List<?> selectItemdataList(ItemdataDefaultVO searchVO) throws Exception {
        return itemdataDAO.selectItemdataList(searchVO);
    }

    /**
	 * itemdata 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return itemdata 총 갯수
	 * @exception
	 */
    public int selectItemdataListTotCnt(ItemdataDefaultVO searchVO) {
		return itemdataDAO.selectItemdataListTotCnt(searchVO);
	}
    
}
