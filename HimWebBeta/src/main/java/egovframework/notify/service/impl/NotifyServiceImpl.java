package egovframework.notify.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.notify.service.NotifyService;
import egovframework.notify.service.NotifyDefaultVO;
import egovframework.notify.service.NotifyVO;
import egovframework.notify.service.impl.NotifyMapper;
/**
 * @Class Name : NotifyServiceImpl.java
 * @Description : Notify Business Implement class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("notifyService")
public class NotifyServiceImpl extends EgovAbstractServiceImpl implements
        NotifyService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyServiceImpl.class);

    @Resource(name="notifyMapper")
    private NotifyMapper notifyDAO;
    
    //@Resource(name="notifyDAO")
    //private NotifyDAO notifyDAO;
    
    /** ID Generation */
    //@Resource(name="{egovNotifyIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * notify을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NotifyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertNotify(NotifyVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	notifyDAO.insertNotify(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * notify을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NotifyVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateNotify(NotifyVO vo) throws Exception {
        notifyDAO.updateNotify(vo);
    }

    /**
	 * notify을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NotifyVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteNotify(NotifyVO vo) throws Exception {
        notifyDAO.deleteNotify(vo);
    }

    /**
	 * notify을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NotifyVO
	 * @return 조회한 notify
	 * @exception Exception
	 */
    public NotifyVO selectNotify(NotifyVO vo) throws Exception {
        NotifyVO resultVO = notifyDAO.selectNotify(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * notify 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notify 목록
	 * @exception Exception
	 */
    public List<?> selectNotifyList(NotifyDefaultVO searchVO) throws Exception {
        return notifyDAO.selectNotifyList(searchVO);
    }

    /**
	 * notify 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notify 총 갯수
	 * @exception
	 */
    public int selectNotifyListTotCnt(NotifyDefaultVO searchVO) {
		return notifyDAO.selectNotifyListTotCnt(searchVO);
	}
    
}
