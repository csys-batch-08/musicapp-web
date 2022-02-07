package com.webmusic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.daoimpl.LibraryDao;
import com.webmusic.model.Library;

@WebServlet("/ShowSongAdmin")
public class ShowSongAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowSongAdmin() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LibraryDao libraryDao = new LibraryDao();
			List<Library> objsonglist = (List<Library>) request.getAttribute("allSongs");
			objsonglist = libraryDao.showAllSongs();
			
			request.setAttribute("AllSongsAdmin", objsonglist);
			RequestDispatcher rd = request.getRequestDispatcher("showSongAdmin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
