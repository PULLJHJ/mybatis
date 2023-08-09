package com.gaem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaem.common.CommonView;
import com.gaem.service.BoardInfoService;
import com.gaem.service.impl.BoardInfoServiceImpl;
import com.gaem.vo.BoardInfoVO;
import com.google.gson.Gson;

@WebServlet("/json/*")
public class JsonServlet extends HttpServlet{
//json servlet 만든 이유 -> json형태로 변환하기 위해서, cors하려고
	
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private BoardInfoService biService = new BoardInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
		BoardInfoVO board = new BoardInfoVO();
		board.setSearchStr(request.getParameter("searchStr"));
		board.setSearchType(request.getParameter("searchType"));
		json = gson.toJson(biService.selectBoardInfoList(board));
		}else if("one".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			json = gson.toJson(biService.selectBaordInfo(biNum));
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
