package egovframework.inventory.service.impl;

import java.util.List;

import egovframework.inventory.service.ItemdataVO;
import egovframework.inventory.service.ItemdataDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : ItemdataMapper.java
 * @Description : Itemdata Mapper Class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("itemdataMapper")
public interface ItemdataMapper {

	/**
	 * itemdata을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ItemdataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertItemdata(ItemdataVO vo) throws Exception;

    /**
	 * itemdata을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ItemdataVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateItemdata(ItemdataVO vo) throws Exception;

    /**
	 * itemdata을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ItemdataVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteItemdata(ItemdataVO vo) throws Exception;

    /**
	 * itemdata을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ItemdataVO
	 * @return 조회한 itemdata
	 * @exception Exception
	 */
    public ItemdataVO selectItemdata(ItemdataVO vo) throws Exception;

    /**
	 * itemdata 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return itemdata 목록
	 * @exception Exception
	 */
    public List<?> selectItemdataList(ItemdataDefaultVO searchVO) throws Exception;

    /**
	 * itemdata 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return itemdata 총 갯수
	 * @exception
	 */
    public int selectItemdataListTotCnt(ItemdataDefaultVO searchVO);

}
