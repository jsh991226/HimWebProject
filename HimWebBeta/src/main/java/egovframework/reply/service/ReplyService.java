package egovframework.reply.service;

import java.util.List;
import egovframework.reply.service.ReplyDefaultVO;
import egovframework.reply.service.ReplyVO;

/**
 * @Class Name : ReplyService.java
 * @Description : Reply Business class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ReplyService {
	
	/**
	 * reply을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ReplyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertReply(ReplyVO vo) throws Exception;
    
    /**
	 * reply을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ReplyVO
	 * @return void형
	 * @exception Exception
	 */
    void updateReply(ReplyVO vo) throws Exception;
    
    /**
	 * reply을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ReplyVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteReply(ReplyVO vo) throws Exception;
    
    /**
	 * reply을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ReplyVO
	 * @return 조회한 reply
	 * @exception Exception
	 */
    ReplyVO selectReply(ReplyVO vo) throws Exception;
    
    /**
	 * reply 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return reply 목록
	 * @exception Exception
	 */
    List selectReplyList(ReplyDefaultVO searchVO) throws Exception;
    
    /**
	 * reply 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return reply 총 갯수
	 * @exception
	 */
    int selectReplyListTotCnt(ReplyDefaultVO searchVO);
    
}
