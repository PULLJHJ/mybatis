package com.gaem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaem.common.CommonView;

@WebServlet("/calc/*")
public class CalcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String cmd = CommonView.getCmd(request);
 		
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String operator = request.getParameter("op");
        int result = 0;
        
        if("+".equals(operator)) {
        	result = num1 + num2;
        }else if("-".equals(operator)) {
        	result = num1 - num2;
        }else if("x".equals(operator)) {
        	result = num1 * num2;
        }else if("/".equals(operator)) {
        	result = num1 / num2;
        }
        response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
    }
    
}
