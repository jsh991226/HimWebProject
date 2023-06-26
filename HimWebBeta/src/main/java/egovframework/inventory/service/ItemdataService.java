package egovframework.inventory.service;

import java.util.List;
import egovframework.inventory.service.ItemdataDefaultVO;
import egovframework.inventory.service.ItemdataVO;

/**
 * @Class Name : ItemdataService.java
 * @Description : Itemdata Business class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ItemdataService {
	
	/**
	 * itemdata을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ItemdataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertItemdata(ItemdataVO vo) throws Exception;
    
    /**
	 * itemdata을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ItemdataVO
	 * @return void형
	 * @exception Exception
	 */
    void updateItemdata(ItemdataVO vo) throws Exception;
    
    /**
	 * itemdata을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ItemdataVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteItemdata(ItemdataVO vo) throws Exception;
    
    /**
	 * itemdata을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ItemdataVO
	 * @return 조회한 itemdata
	 * @exception Exception
	 */
    ItemdataVO selectItemdata(ItemdataVO vo) throws Exception;
    
    /**
	 * itemdata 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return itemdata 목록
	 * @exception Exception
	 */
    List selectItemdataList(ItemdataDefaultVO searchVO) throws Exception;
    
    /**
	 * itemdata 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return itemdata 총 갯수
	 * @exception
	 */
    int selectItemdataListTotCnt(ItemdataDefaultVO searchVO);
    
}
