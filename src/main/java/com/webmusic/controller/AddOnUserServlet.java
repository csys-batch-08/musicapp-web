package com.webmusic.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.UserInfoDao;
import com.webmusic.model.UserInfo;
@WebServlet("/addOnUser")
public class AddOnUserServlet extends HttpServlet {


	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
            UserInfoDao userDao = new UserInfoDao();

            String email = req.getParameter("UserEmail");
			System.out.println(email);
				    		
			HttpSession session=req.getSession();
	        UserInfo user=(UserInfo)session.getAttribute("PremiumUser");     
	       boolean addOnFlag=userDao.findUserAlreadyAddOn(user);
	        if(user.getRole().equals("Premium")&&addOnFlag==true) {
			
	        	
	        	int i=userDao.AddOnUser(email,user);
			
			if(i>0) {
				   res.sendRedirect("exceptionAddUser.jsp");
				
			       }
			         else 
			               {
				             res.getWriter().print("User not Added");
			               }
	              }
	        else
	          {
	        	
	        	res.sendRedirect("exceptionUserLimit.jsp");
	          }
		    
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		
	} 
}
