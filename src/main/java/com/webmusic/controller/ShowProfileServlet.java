package com.webmusic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.model.UserInfo;

@WebServlet("/showUserProfile")
public class ShowProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowProfileServlet() {
		super();

	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserInfo currentUser = (UserInfo) session.getAttribute("currentUser");
		UserInfo premiumUser = (UserInfo) session.getAttribute("PremiumUser");
		if (premiumUser != null) {

			request.setAttribute("premiumUser", premiumUser);
			RequestDispatcher rd = request.getRequestDispatcher("updatePremiumUser.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			request.setAttribute("user", currentUser);
			RequestDispatcher rd = request.getRequestDispatcher("updateUser.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}

	}

}
