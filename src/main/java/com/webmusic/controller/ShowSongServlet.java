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

/**
 * Servlet implementation class ShowSongServlet
 */
@WebServlet("/ShowSongServlet")
public class ShowSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
			LibraryDao libraryDao = new   LibraryDao();
			List<Library> objsonglist = (List<Library>)request.getAttribute("allSongs");
			objsonglist=libraryDao.showAllSongs();
             System.out.println("ser"+objsonglist);


			request.setAttribute("AllSongs",objsonglist);
			RequestDispatcher rd=request.getRequestDispatcher("ShowSongUser.jsp");
			//response.sendRedirect("ShowSongUser.jsp");
			rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
