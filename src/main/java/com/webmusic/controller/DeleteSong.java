package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.daoimpl.LibraryDao;

@WebServlet("/deletesong")
public class DeleteSong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteSong() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String songTitle = request.getParameter("songTitle");
			LibraryDao librarydao = new LibraryDao();

			boolean b = librarydao.deleteSong(songTitle);
			if (b == true) {
				response.sendRedirect("DeleteSonglistServlet");
			} else {
				response.getWriter().print("Song not deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
