package com.webmusic.controller;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.DaoImpl.UserInfoDao;
import com.webmusic.model.UserInfo;
@WebServlet("/switch")
public class SwitchUserServlet extends HttpServlet {


	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
            UserInfoDao userDao = new UserInfoDao();

		
			HttpSession session=req.getSession();
	        UserInfo user=(UserInfo)session.getAttribute("currentUser");
	        Double amount = user.getWallet();
	        if(amount>=150) {
	        	
	        	
	       
				
				
				UserInfoDao userdao=new UserInfoDao();
				 int result=userdao.SwitchToPremium(user);
				 if(user.getWallet()>amount) {
					 System.out.println("User upgraded");
				 if(result>0)
				 {
					 user.setRole("Premium");
					 req.getSession().setAttribute("PremiumUser", user);
					 req.getSession().setAttribute("currentUser", null);
					 res.sendRedirect("login.jsp");
					 System.out.println("amount is deducted");
				 }
				 
				 else
				 {
					 System.out.println("insufficient balance");
				 }
//					response.getWriter("Recharge Succesfull");
				}
		
					
			if(user!=null) {
				res.sendRedirect("login.jsp");
				
			}
//			else 
//			{
//		
//				res.sendRedirect("Wallet.jsp");
//	        }
//	       
			}
	        else {
               PrintWriter write = res.getWriter();			
				
				String someMessage = "Not Having Sufficient Amount !";
				write.println("<script type='text/javascript'>");
				write.println("alert(" + "'" + someMessage + "'" + ");</script>");
				write.println("</head><body></body></html>");
				System.out.println("inside  111");
	        	
		       	res.sendRedirect("Wallet.jsp");

	        }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		
	} 

}