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

/**
 * Servlet implementation class PlaylistUserServlet
 */
@WebServlet("/PlaylistUserServlet")
public class PlaylistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PlaylistDao playlistDao = new PlaylistDao();
        List<Playlist> showPlaylist = new ArrayList<Playlist>();
        showPlaylist = playlistDao.showAllPlaylist();

    	request.setAttribute("AllPlaylist",showPlaylist);
		RequestDispatcher rd=request.getRequestDispatcher("ShowPlaylistUser.jsp");	
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
