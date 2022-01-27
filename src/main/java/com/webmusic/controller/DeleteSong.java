package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.DaoImpl.LibraryDao;
import com.webmusic.DaoImpl.UserInfoDao;

/**
 * Servlet implementation class DeleteSong
 */
@WebServlet("/deletesong")
public class DeleteSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteSong() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

			
			String SongTitle = request.getParameter("songTitle");
			LibraryDao librarydao = new LibraryDao();
			try {
				boolean b=librarydao.deleteSong(SongTitle);
				if(b==true)
				{
					System.out.println(" song is deleted");
					response.sendRedirect("Showsong.jsp");
					
				}else
				{
					response.getWriter().print("Song not deleted");
				}
				
			
			
			
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
