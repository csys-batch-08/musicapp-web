package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.LibraryDao;
import com.webmusic.daoimpl.PlaylistDao;
import com.webmusic.model.Playlist;
import com.webmusic.model.UserInfo;


@WebServlet("/deleteplaylist")
public class DeletePlaylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeletePlaylist() {
        super();

    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String playlisttitle = request.getParameter("plname");
		HttpSession session=request.getSession();
		UserInfo user = (UserInfo)	session.getAttribute("PremiumUser");
		
		
		PlaylistDao playlistdao = new PlaylistDao();
			
			boolean b=playlistdao.deletePlaylist(playlisttitle, user.getEmailId());
			if(b==true)
			{
			response.sendRedirect("DeletePlaylistServlet");
				
			}else {
				response.getWriter().print("You'r playlist is not deleted!!");
			}
		}  catch (Exception e) {

			e.printStackTrace();
		}
	}



}
