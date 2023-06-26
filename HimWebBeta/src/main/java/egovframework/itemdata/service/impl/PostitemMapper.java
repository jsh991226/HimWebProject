package egovframework.itemdata.service.impl;

import java.util.List;

import egovframework.itemdata.service.PostitemVO;
import egovframework.itemdata.service.PostitemDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : PostitemMapper.java
 * @Description : Postitem Mapper Class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("postitemMapper")
public interface PostitemMapper {

	/**
	 * postitem을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PostitemVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertPostitem(PostitemVO vo) throws Exception;

    /**
	 * postitem을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PostitemVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePostitem(PostitemVO vo) throws Exception;

    /**
	 * postitem을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PostitemVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePostitem(PostitemVO vo) throws Exception;

    /**
	 * postitem을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PostitemVO
	 * @return 조회한 postitem
	 * @exception Exception
	 */
    public PostitemVO selectPostitem(PostitemVO vo) throws Exception;

    /**
	 * postitem 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return postitem 목록
	 * @exception Exception
	 */
    public List<?> selectPostitemList(PostitemDefaultVO searchVO) throws Exception;
    public List<?> selectPostitemListAll(PostitemDefaultVO searchVO) throws Exception;

    /**
	 * postitem 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return postitem 총 갯수
	 * @exception
	 */
    public int selectPostitemListTotCnt(PostitemDefaultVO searchVO);

}
