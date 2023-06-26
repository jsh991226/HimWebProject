package egovframework.reply.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.reply.service.ReplyService;
import egovframework.reply.service.ReplyDefaultVO;
import egovframework.reply.service.ReplyVO;
import egovframework.reply.service.impl.ReplyMapper;
/**
 * @Class Name : ReplyServiceImpl.java
 * @Description : Reply Business Implement class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("replyService")
public class ReplyServiceImpl extends EgovAbstractServiceImpl implements
        ReplyService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ReplyServiceImpl.class);

    @Resource(name="replyMapper")
    private ReplyMapper replyDAO;
    
    //@Resource(name="replyDAO")
    //private ReplyDAO replyDAO;
    
    /** ID Generation */
    //@Resource(name="{egovReplyIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * reply을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ReplyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertReply(ReplyVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	replyDAO.insertReply(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * reply을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ReplyVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateReply(ReplyVO vo) throws Exception {
        replyDAO.updateReply(vo);
    }

    /**
	 * reply을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ReplyVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteReply(ReplyVO vo) throws Exception {
        replyDAO.deleteReply(vo);
    }

    /**
	 * reply을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ReplyVO
	 * @return 조회한 reply
	 * @exception Exception
	 */
    public ReplyVO selectReply(ReplyVO vo) throws Exception {
        ReplyVO resultVO = replyDAO.selectReply(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * reply 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return reply 목록
	 * @exception Exception
	 */
    public List<?> selectReplyList(ReplyDefaultVO searchVO) throws Exception {
        return replyDAO.selectReplyList(searchVO);
    }

    /**
	 * reply 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return reply 총 갯수
	 * @exception
	 */
    public int selectReplyListTotCnt(ReplyDefaultVO searchVO) {
		return replyDAO.selectReplyListTotCnt(searchVO);
	}
    
}
