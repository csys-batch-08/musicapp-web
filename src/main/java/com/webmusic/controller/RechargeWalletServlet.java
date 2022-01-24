package com.webmusic.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.DaoImpl.UserInfoDao;
import com.webmusic.model.UserInfo;

@WebServlet("/recharge")
public class RechargeWalletServlet extends HttpServlet {


	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
            UserInfoDao userDao = new UserInfoDao();

            String email = req.getParameter("UserEmail");
			System.out.println(email);
			Double cardNumber = Double.parseDouble(req.getParameter("AccountNumber"));
			System.out.println(cardNumber);
			Double cvv = Double.parseDouble(req.getParameter("cvv"));
			System.out.println(cvv);
			long mboNum = Long.parseLong(req.getParameter("MobileNumber"));
			System.out.println(mboNum);
			Double amount = Double.parseDouble(req.getParameter("Amount"));
			System.out.println(amount);
			
			 UserInfo update=new UserInfo(null,null,email,null,null,null, mboNum, amount);
				UserInfoDao upd=new UserInfoDao();
			    upd.UpdateUserWallet(update);
		
			
		
			HttpSession session=req.getSession();
	        UserInfo user=(UserInfo)session.getAttribute("currentUser");
	        user.setWallet(amount);
			//int i=userDao.UpdateUserWallet(user);
			if(user!=null) {
				res.sendRedirect("ExceptionAdd.jsp");
				
			}
			else 
			{
				res.getWriter().print("wallet not recharged");
			}

		    
		    
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		
	} 
}