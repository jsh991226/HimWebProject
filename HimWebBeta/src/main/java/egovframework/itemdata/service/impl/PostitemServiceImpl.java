package egovframework.itemdata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.itemdata.service.PostitemService;
import egovframework.itemdata.service.PostitemDefaultVO;
import egovframework.itemdata.service.PostitemVO;
import egovframework.itemdata.service.impl.PostitemMapper;
/**
 * @Class Name : PostitemServiceImpl.java
 * @Description : Postitem Business Implement class
 * @Modification Information
 *
 * @author coc
 * @since 2023
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("postitemService")
public class PostitemServiceImpl extends EgovAbstractServiceImpl implements
        PostitemService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(PostitemServiceImpl.class);

    @Resource(name="postitemMapper")
    private PostitemMapper postitemDAO;
    
    //@Resource(name="postitemDAO")
    //private PostitemDAO postitemDAO;
    
    /** ID Generation */
    //@Resource(name="{egovPostitemIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * postitem을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PostitemVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPostitem(PostitemVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	postitemDAO.insertPostitem(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * postitem을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PostitemVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePostitem(PostitemVO vo) throws Exception {
        postitemDAO.updatePostitem(vo);
    }

    /**
	 * postitem을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PostitemVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePostitem(PostitemVO vo) throws Exception {
        postitemDAO.deletePostitem(vo);
    }

    /**
	 * postitem을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PostitemVO
	 * @return 조회한 postitem
	 * @exception Exception
	 */
    public PostitemVO selectPostitem(PostitemVO vo) throws Exception {
        PostitemVO resultVO = postitemDAO.selectPostitem(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * postitem 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return postitem 목록
	 * @exception Exception
	 */
    public List<?> selectPostitemList(PostitemDefaultVO searchVO) throws Exception {
        return postitemDAO.selectPostitemList(searchVO);
    }

    public List<?> selectPostitemListAll(PostitemDefaultVO searchVO) throws Exception {
        return postitemDAO.selectPostitemListAll(searchVO);
    }
    /**
	 * postitem 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return postitem 총 갯수
	 * @exception
	 */
    public int selectPostitemListTotCnt(PostitemDefaultVO searchVO) {
		return postitemDAO.selectPostitemListTotCnt(searchVO);
	}
    
}
