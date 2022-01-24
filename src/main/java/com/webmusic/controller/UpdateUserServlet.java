package com.webmusic.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.DaoImpl.UserInfoDao;
import com.webmusic.model.UserInfo;

@WebServlet("/Update")
public class UpdateUserServlet extends HttpServlet {


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
            

			long mboNum = Long.parseLong(req.getParameter("MobileNumber"));
			System.out.println(mboNum);

		    UserInfo update=new UserInfo(fname,lname,email,uname,password,null,mboNum,0);
			UserInfoDao upd=new UserInfoDao();
		    upd.update(update);
		    if(upd!=null) {
//				res.getWriter().print("You'r Details are updated..!");
			  res.sendRedirect("login.jsp");

			}
			else 
			{
				res.getWriter().print("User Not updated");
			}
	
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		
	} 
}