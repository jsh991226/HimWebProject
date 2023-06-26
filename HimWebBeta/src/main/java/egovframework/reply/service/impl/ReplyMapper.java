package egovframework.reply.service.impl;

import java.util.List;

import egovframework.reply.service.ReplyVO;
import egovframework.reply.service.ReplyDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : ReplyMapper.java
 * @Description : Reply Mapper Class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("replyMapper")
public interface ReplyMapper {

	/**
	 * reply을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ReplyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertReply(ReplyVO vo) throws Exception;

    /**
	 * reply을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ReplyVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateReply(ReplyVO vo) throws Exception;

    /**
	 * reply을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ReplyVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteReply(ReplyVO vo) throws Exception;

    /**
	 * reply을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ReplyVO
	 * @return 조회한 reply
	 * @exception Exception
	 */
    public ReplyVO selectReply(ReplyVO vo) throws Exception;

    /**
	 * reply 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return reply 목록
	 * @exception Exception
	 */
    public List<?> selectReplyList(ReplyDefaultVO searchVO) throws Exception;

    /**
	 * reply 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return reply 총 갯수
	 * @exception
	 */
    public int selectReplyListTotCnt(ReplyDefaultVO searchVO);

}
