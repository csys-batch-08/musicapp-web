package com.webmusic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.DaoImpl.PlaylistDao;
import com.webmusic.model.Playlist;


@WebServlet("/PlaylistAdminServlet")
public class PlaylistAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PlaylistAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PlaylistDao playlistDao = new PlaylistDao();
        List<Playlist> showPlaylist = new ArrayList<Playlist>();
        showPlaylist = playlistDao.showAllPlaylist();

    	request.setAttribute("AllPlaylistAdmin",showPlaylist);
		RequestDispatcher rd=request.getRequestDispatcher("showPlaylist.jsp");	
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
