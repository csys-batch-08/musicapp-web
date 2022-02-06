package com.webmusic.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.LibraryDao;
import com.webmusic.daoimpl.LoginDao;
import com.webmusic.exception.LoginException;
import com.webmusic.model.Admin;
import com.webmusic.model.Library;
import com.webmusic.model.UserInfo;

@WebServlet("/login")
public class Login extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserInfo checkUser = null;
		String uname = req.getParameter("text");

		String password = req.getParameter("pass");

		
		LoginDao loginDao = new LoginDao();
		try 
		{
			
			
			
				Admin admin = loginDao.Checkadmin(uname, password);
				
				if(admin!=null)
				{   
					HttpSession session=req.getSession();
					session.setAttribute("Adminstaration", admin);
					System.out.println("admin");
				 
				    LibraryDao libraryDao = new   LibraryDao();
					List<Library> objsonglist = (List<Library>)req.getAttribute("allSongs");
					objsonglist=libraryDao.showAllSongs();

					req.setAttribute("AdminHome",objsonglist);
					RequestDispatcher rd=req.getRequestDispatcher("admin.jsp");
				    
					
					try {
						rd.forward(req, res);
					} catch (ServletException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					}
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
					LibraryDao libraryDao = new   LibraryDao();
					List<Library> objsonglist = (List<Library>)req.getAttribute("allSongs");
					objsonglist=libraryDao.showAllSongs();

					req.setAttribute("AllSongsPremium",objsonglist);
					RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
					
					try {
						rd.forward(req, res);
					} catch (ServletException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					}
					}
					else 
					{
						HttpSession session=req.getSession();
						session.setAttribute("currentUser", user);
						LibraryDao libraryDao = new   LibraryDao();
						List<Library> objsonglist = (List<Library>)req.getAttribute("allSongs");
						objsonglist=libraryDao.showAllSongs();
	
						req.setAttribute("AllSongs",objsonglist);
						RequestDispatcher rd=req.getRequestDispatcher("user.jsp");
		
						try {
							rd.forward(req, res);
						} catch (ServletException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						}
						
						
					}
					}
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
			
		} catch (Exception e) {

		e.printStackTrace();
	} 
		
	}

}
