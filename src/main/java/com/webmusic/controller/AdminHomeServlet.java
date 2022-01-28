package com.webmusic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.DaoImpl.LibraryDao;
import com.webmusic.model.Library;

@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminHomeServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  LibraryDao libraryDao = new   LibraryDao();
			List<Library> objsonglist = (List<Library>)request.getAttribute("allSongs");
			objsonglist=libraryDao.showAllSongs();

			request.setAttribute("AdminHome",objsonglist);
			RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
