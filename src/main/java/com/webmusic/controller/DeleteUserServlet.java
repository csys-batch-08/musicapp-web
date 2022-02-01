package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.webmusic.DaoImpl.UserInfoDao;


@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteUserServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String UserName=request.getParameter("uname");
		UserInfoDao userdao=new UserInfoDao();
		try {
			userdao.delete(UserName);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		if(userdao!=null) {
			System.out.println(" user is deleted");
			response.sendRedirect("ShowUserServlet");
		}else
		{
			response.getWriter().print("User is not deleted");
		}
		
		
		
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
