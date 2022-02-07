package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.PlaylistDao;
import com.webmusic.daoimpl.UserInfoDao;
import com.webmusic.model.UserInfo;

@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String userName = request.getParameter("uname");
			UserInfoDao userdao = new UserInfoDao();

			boolean b = userdao.delete(userName);

			if (b == true) {
				response.sendRedirect("ShowUserServlet");
			} else {
				response.getWriter().print("User is not deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
