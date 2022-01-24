package com.webmusic.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.DaoImpl.LoginDao;
import com.webmusic.exception.LoginException;
import com.webmusic.model.Admin;
import com.webmusic.model.UserInfo;

@WebServlet("/login")
public class Login extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserInfo checkUser = null;
		String uname = req.getParameter("text");
		//System.out.println(uname);
		
		String password = req.getParameter("pass");
		//System.out.println(password);
			
		
		LoginDao loginDao = new LoginDao();
		try 
		{
			
			
			
				Admin admin = loginDao.Checkadmin(uname, password);
				
				if(admin!=null)
				{   
					HttpSession session=req.getSession();
					session.setAttribute("Adminstaration", admin);
					System.out.println("admin");
				    res.sendRedirect("Admin.jsp");
				}
				else if(admin==null)
				{
					System.out.println("user");
					UserInfo user=loginDao.login(uname,password);
				
					if(user!=null) {
					if(user.getRole().equals("Premium"))
					{
						
					HttpSession session=req.getSession();
					session.setAttribute("PremiumUser", user);
					res.sendRedirect("home.jsp");
					}
					else 
					{
						HttpSession session=req.getSession();
						session.setAttribute("currentUser", user);
						res.sendRedirect("user.jsp");
						
					}}
					else {
						throw new LoginException();
					}
				
					
					
				}
				else {
					throw new LoginException();
				}
				
					
				

		}
		
				
	
	catch (LoginException e) {
			HttpSession session=req.getSession();
			session.setAttribute("errors", e.getMessage());
			res.sendRedirect("login.jsp");
			
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
