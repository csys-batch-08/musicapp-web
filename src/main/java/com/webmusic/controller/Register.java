package com.webmusic.controller;

import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.DaoImpl.UserInfoDao;
import com.webmusic.model.UserInfo;


@WebServlet("/registerweb")
public class Register extends HttpServlet {


	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
			UserInfoDao userDao = new UserInfoDao();
			
			String fname = req.getParameter("FirstName");
			System.out.println(fname);
			
			String lname = req.getParameter("LastName");
			System.out.println(lname);
			
			String email = req.getParameter("UserEmail");
			System.out.println(email);
			email = email.trim().toLowerCase();
			
			String uname = req.getParameter("UserName");
			System.out.println(uname);
			
			String password = req.getParameter("UserPassword");
			System.out.println(password);
            
			String role = req.getParameter("Role");
			System.out.println(role);
			
			long mboNum = Long.parseLong(req.getParameter("MobileNumber"));
			System.out.println(mboNum);

			UserInfo userInfo=new UserInfo(fname,lname,email,uname,password,role,mboNum,0);
			UserInfoDao uid=new UserInfoDao();
		
			uid.insertUser(userInfo);
				
			
				if(uid!=null) {
					res.sendRedirect("login.jsp");
					
				}
				else 
				{
					res.getWriter().print("Not registered");
				}

				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
	
		
	}
}



