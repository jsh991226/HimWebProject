package egovframework.itemdata.service;

import java.util.List;
import egovframework.itemdata.service.PostitemDefaultVO;
import egovframework.itemdata.service.PostitemVO;

/**
 * @Class Name : PostitemService.java
 * @Description : Postitem Business class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PostitemService {
	
	/**
	 * postitem을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PostitemVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPostitem(PostitemVO vo) throws Exception;
    
    /**
	 * postitem을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PostitemVO
	 * @return void형
	 * @exception Exception
	 */
    void updatePostitem(PostitemVO vo) throws Exception;
    
    /**
	 * postitem을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PostitemVO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePostitem(PostitemVO vo) throws Exception;
    
    /**
	 * postitem을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PostitemVO
	 * @return 조회한 postitem
	 * @exception Exception
	 */
    PostitemVO selectPostitem(PostitemVO vo) throws Exception;
    
    /**
	 * postitem 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return postitem 목록
	 * @exception Exception
	 */
    List selectPostitemList(PostitemDefaultVO searchVO) throws Exception;
    List selectPostitemListAll(PostitemDefaultVO searchVO) throws Exception;
    
    /**
	 * postitem 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return postitem 총 갯수
	 * @exception
	 */
    int selectPostitemListTotCnt(PostitemDefaultVO searchVO);
    
}
