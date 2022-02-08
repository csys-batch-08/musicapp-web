package com.webmusic.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.UserInfoDao;
import com.webmusic.model.UserInfo;

@WebServlet("/recharge")
public class RechargeWalletServlet extends HttpServlet {


	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
            

            String email = req.getParameter("UserEmail");

			long mboNum = Long.parseLong(req.getParameter("MobileNumber"));
			System.out.println(mboNum);
			Double amount = Double.parseDouble(req.getParameter("Amount"));
			System.out.println(amount);
			
			 UserInfo update=new UserInfo(null,null,email,null,null,null, mboNum, amount);
				UserInfoDao upd=new UserInfoDao();
			   int flag= upd.UpdateUserWallet(update);
		
			
		
			HttpSession session=req.getSession();
	        UserInfo user=(UserInfo)session.getAttribute("currentUser");
	        user.setWallet(amount);

			if(flag>0) {
				res.sendRedirect("exceptionAdd.jsp");
				
			}
			else 
			{
				res.getWriter().print("wallet not recharged");
			}

		    
			} catch (Exception e) {
				e.getMessage();
			} 
			
		
	} 
}