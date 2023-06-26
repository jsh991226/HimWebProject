package egovframework.user.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.icu.text.SimpleDateFormat;

import egovframework.itemdata.service.PostitemService;
import egovframework.itemdata.service.PostitemVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.user.service.UserService;
import egovframework.user.service.UserDefaultVO;
import egovframework.user.service.UserVO;

/**
 * @Class Name : UserController.java
 * @Description : User Controller class
 * @Modification Information
 *
 * @author jsh
 * @since 2023
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = UserVO.class)
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "postitemService")
	private PostitemService postitemService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/**
	 * user 목록을 조회한다. (pageing)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 UserDefaultVO
	 * @return "/user/UserList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/user/UserList.do")
	public String selectUserList(@ModelAttribute("searchVO") UserDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> userList = userService.selectUserList(searchVO);
		model.addAttribute("resultList", userList);

		int totCnt = userService.selectUserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/user/UserList";
	}

	@RequestMapping(value = "/user/getUserMoney.do")
	public @ResponseBody int getUserMoney(@RequestParam("id") String id, @RequestParam("itemId") int itemId,
			@RequestParam("itemCost") int itemCost, @RequestParam("itemData") String itemData,
			HttpServletRequest request, UserVO vo) throws Exception {
		System.out.println("유저 : " + id);
		vo.setFirstIndex(0); // offset 변경
		vo.setUserid(id);
		UserVO _result = userService.selectUser(vo);
		ModelAndView jsonView = new ModelAndView("jsonView");
		jsonView.addObject("result", _result);
		if (_result.getMoney() >= itemCost) {
			vo.setMoney(_result.getMoney() - itemCost);
			userService.updateUserMoney(vo);
			PostitemVO _itemVo = new PostitemVO();
			_itemVo.setOwnerid(id);
			_itemVo.setItemdataname(itemData);
			_itemVo.setVaild("1");
			postitemService.insertPostitem(_itemVo);
			return 1;

		} else {
			return -1;
		}

	}

	@RequestMapping("/user/checkUserLogin.do")
	public String checkUserLogin(HttpServletRequest request, UserVO userVO, Model model) throws Exception {
		System.out.println("userid : " + userVO.getUserid());
		System.out.println("userpass : " + userVO.getUserpw());
		userVO = userService.checkUserLogin(userVO);
		HttpSession session = request.getSession();
		session.setAttribute("userVO", userVO);
		System.out.println("닉네임 : " + userVO.getNickname());
		model.addAttribute("userVO", userVO);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/user/checkUserLoginAjax.do")
	public @ResponseBody int checkUserLoginAjax(HttpServletRequest request, Model model) throws Exception {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		UserVO userVO = new UserVO();
		userVO.setUserid(userid);
		userVO.setUserpw(userpw);
		userVO = userService.checkUserLogin(userVO);
		HttpSession session = request.getSession();
		session.setAttribute("userVO", userVO);
		model.addAttribute("userVO", userVO);
		if (userVO.getNickname() != null )return 1;
		else
		return 0;

	}

	@RequestMapping("/user/logout.do")
	public String logout(HttpServletRequest request, UserVO userVO, Model model) throws Exception {
		request.getSession().removeAttribute("userVO");
		HttpSession session = request.getSession();
		session.setAttribute("userVO", null);
		session.removeAttribute("userVO");
		session.invalidate();
		model.addAttribute("userVO", null);
		System.out.println("로그아웃");
		return "redirect:/index.jsp";

	}
	
	@RequestMapping(value = "/user/RankTop.do")
	public @ResponseBody List<UserVO> RankTop(HttpServletRequest request, @ModelAttribute("searchVO") UserDefaultVO searchVO,
			ModelMap model) throws Exception {
		
		
		List<UserVO> rankList = userService.selectUserList(searchVO);


		return rankList;
	}


	@RequestMapping(value = "/user/Rank.do")
	public String RankList(HttpServletRequest request, @ModelAttribute("searchVO") UserDefaultVO searchVO,
			ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> rankList = userService.selectUserList(searchVO);
		model.addAttribute("RankList", rankList);

		int totCnt = userService.selectUserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		request.getSession().setAttribute("RankList", rankList);



		return "redirect:/rank.jsp";
	}


	@RequestMapping(value = "/user/gen.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String gen(HttpServletRequest request) {
		String text = request.getParameter("quest");
		try {
			
			URL url = new URL("https://api.openai.com/v1/completions");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			// System.out.println(key);
			con.setRequestProperty("Authorization", "Bearer " + key);
			con.setDoOutput(true);
			String input = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + text + "\",\"max_tokens\":256}";
			try (OutputStream os = con.getOutputStream()) {
				byte[] inputBytes = input.getBytes("utf-8");
				os.write(inputBytes, 0, inputBytes.length);
			}
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = new JSONObject();
				String jsonStr = response.toString();
				String resultText = "";
				try {
					jsonObj = (JSONObject) parser.parse(jsonStr);
					JSONArray jsonArr = (JSONArray) jsonObj.get("choices");
					for(int i=0;i<jsonArr.size();i++){
						JSONObject jsonObj2 = (JSONObject)jsonArr.get(i);
						resultText = (String)jsonObj2.get("text");
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return resultText;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "서버에 문제가 있어 실행할 수 없습니다";
		}
		
	}

	final String key = "writer your openai gpt Key";

	public String callAPI(String prompt) {
		try {

			URL url = new URL("https://api.openai.com/v1/completions");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			// System.out.println(key);
			con.setRequestProperty("Authorization", "Bearer " + key);
			con.setDoOutput(true);
			String input = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + prompt + "\",\"max_tokens\":256}";
			try (OutputStream os = con.getOutputStream()) {
				byte[] inputBytes = input.getBytes("utf-8");
				os.write(inputBytes, 0, inputBytes.length);
			}
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = new JSONObject();
				String jsonStr = response.toString();
				String resultText = "";
				try {
					jsonObj = (JSONObject) parser.parse(jsonStr);
					JSONArray jsonArr = (JSONArray) jsonObj.get("choices");
					for(int i=0;i<jsonArr.size();i++){
						JSONObject jsonObj2 = (JSONObject)jsonArr.get(i);
						resultText = (String)jsonObj2.get("text");
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return resultText;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "서버에 문제가 있어 실행할 수 없습니다";
		}
	}

	@RequestMapping("/user/addUserView.do")
	public String addUserView(@ModelAttribute("searchVO") UserDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("userVO", new UserVO());
		return "/user/UserRegister";
	}

	@RequestMapping("/user/addUser.do")
	public String addUser(UserVO userVO, @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
			throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String nowTime = sdf2.format(now);
		userVO.setRegdate(nowTime);
		userVO.setType("user");
		userVO.setUserclass("notset");
		userVO.setMoney(0);
		status.setComplete();
		userService.insertUser(userVO);
		return "redirect:/index.jsp";
	}

	@RequestMapping("/user/updateUserView.do")
	public String updateUserView(@RequestParam("index") int index, @ModelAttribute("searchVO") UserDefaultVO searchVO,
			Model model) throws Exception {
		UserVO userVO = new UserVO();
		userVO.setIndex(index);
		// 변수명은 CoC 에 따라 userVO
		model.addAttribute(selectUser(userVO, searchVO));
		return "/user/UserRegister";
	}

	@RequestMapping("/user/selectUser.do")
	public @ModelAttribute("userVO") UserVO selectUser(UserVO userVO,
			@ModelAttribute("searchVO") UserDefaultVO searchVO) throws Exception {
		return userService.selectUser(userVO);
	}

	@RequestMapping("/user/updateUser.do")
	public String updateUser(UserVO userVO, @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
			throws Exception {
		userService.updateUser(userVO);
		status.setComplete();
		return "forward:/user/UserList.do";
	}

	@RequestMapping("/user/deleteUser.do")
	public String deleteUser(UserVO userVO, @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
			throws Exception {
		userService.deleteUser(userVO);
		status.setComplete();
		return "forward:/user/UserList.do";
	}

}
