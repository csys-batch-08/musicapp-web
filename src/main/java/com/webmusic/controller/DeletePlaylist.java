package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.DaoImpl.LibraryDao;
import com.webmusic.DaoImpl.PlaylistDao;
import com.webmusic.model.Playlist;
import com.webmusic.model.UserInfo;


@WebServlet("/deleteplaylist")
public class DeletePlaylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeletePlaylist() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String PlaylistTitle = request.getParameter("plname");
		System.out.println("jsp "+PlaylistTitle);
		HttpSession session=request.getSession();
		UserInfo user = (UserInfo)	session.getAttribute("PremiumUser");
		
		
		PlaylistDao playlistdao = new PlaylistDao();
		
		
		try {
			boolean b=playlistdao.deletePlaylist(PlaylistTitle, user.getEmailId());
			if(b==true)
			{
			response.sendRedirect("DeletePlaylistServlet");
				
			}else {
				response.getWriter().print("You'r playlist is not deleted!!");
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
