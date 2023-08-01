package com.gaem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaem.common.CommonView;
import com.gaem.service.BoardInfoService;
import com.gaem.service.impl.BoardInfoServiceImpl;

@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardInfoService biService = new BoardInfoServiceImpl();

	private boolean isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			request.setAttribute("msg", "로그인이 필요한 화면 입니다.");
			request.setAttribute("url", "/user-info/login");
			CommonView.forwardMessage(request, response);
			return false;
		}
		return true;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!isLogin(request,response)) {
			return;
		}
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			Map<String,String> param = null;
			if(request.getParameter("searchType")!=null) {
				param= new HashMap<>();
			String key = request.getParameter("searchType");
			String value = request.getParameter("searchStr");
			param.put("key", key);
			param.put("value", value);
			}
			List<Map<String, String>> list = biService.selectBoardInfoList(param);	
			request.setAttribute("biList", list);
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			Map<String,String> board = biService.selectBaordInfo(biNum);
			request.setAttribute("board", board);
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(!isLogin(request,response)) {
			return;
		}
		String cmd = CommonView.getCmd(request);
		HttpSession session = request.getSession();
		Map<String,String> user = (Map<String,String>)session.getAttribute("user");
		if("insert".equals(cmd)) {
			String biTitle = request.getParameter("biTitle");
			String biContent = request.getParameter("biContent");
			Map<String,String> board = new HashMap<>();
			board.put("biTitle", biTitle);
			board.put("biContent", biContent);
			board.put("uiNum", user.get("uiNum"));
			int result = biService.insertBoardInfo(board);
			request.setAttribute("msg", "등록이 안됬습니다.");
			request.setAttribute("url", "/board-info/insert");
			if(result==1) {
				request.setAttribute("msg", "등록이 되었습니다.");
				request.setAttribute("url", "/board-info/list");
			}
		}else if("update".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			String biTitle = request.getParameter("biTitle");
			String biContent = request.getParameter("biContent");
			Map<String,String> board = new HashMap<>();
			board.put("biNum", biNum);
			board.put("biTitle", biTitle);
			board.put("biContent", biContent);
			board.put("uiNum", user.get("uiNum"));
			int result = biService.updateBaordInfo(board);
			request.setAttribute("msg", "수정이 안됬습니다.");
			request.setAttribute("url", "/board-info/update?biNum=" + biNum);
			if(result==1) {
				request.setAttribute("msg", "수정이 되었습니다.");
				request.setAttribute("url", "/board-info/list");
			}
		}else if("delete".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			int result = biService.deleteBaordInfo(biNum);
			request.setAttribute("msg", "삭제가 안됐습니다.");
			request.setAttribute("url", "/board-info/view?biNum=" + biNum);
			if(result==1) {
				request.setAttribute("msg", "삭제가 되었습니다.");
				request.setAttribute("url", "/board-info/list");
			}
		}
		CommonView.forwardMessage(request, response);
	}

}