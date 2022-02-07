package com.webmusic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.daoimpl.UserInfoDao;
import com.webmusic.model.UserInfo;

@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ShowUserServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
		UserInfoDao userInfoDao = new UserInfoDao();
		List<UserInfo> userList = new ArrayList<>();
        userList = userInfoDao.showAllUsers();

    	request.setAttribute("UserlistAdmin",userList);
		RequestDispatcher rd=request.getRequestDispatcher("showUsers.jsp");	
		rd.forward(request, response);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
