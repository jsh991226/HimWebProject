package egovframework.notify.service;

import java.util.List;
import egovframework.notify.service.NotifyDefaultVO;
import egovframework.notify.service.NotifyVO;

/**
 * @Class Name : NotifyService.java
 * @Description : Notify Business class
 * @Modification Information
 *
 * @author coc
 * @since 20230614
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface NotifyService {
	
	/**
	 * notify을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NotifyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertNotify(NotifyVO vo) throws Exception;
    
    /**
	 * notify을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NotifyVO
	 * @return void형
	 * @exception Exception
	 */
    void updateNotify(NotifyVO vo) throws Exception;
    
    /**
	 * notify을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NotifyVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteNotify(NotifyVO vo) throws Exception;
    
    /**
	 * notify을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NotifyVO
	 * @return 조회한 notify
	 * @exception Exception
	 */
    NotifyVO selectNotify(NotifyVO vo) throws Exception;
    
    /**
	 * notify 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notify 목록
	 * @exception Exception
	 */
    List selectNotifyList(NotifyDefaultVO searchVO) throws Exception;
    
    /**
	 * notify 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notify 총 갯수
	 * @exception
	 */
    int selectNotifyListTotCnt(NotifyDefaultVO searchVO);
    
}
