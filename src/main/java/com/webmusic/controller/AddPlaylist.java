package com.webmusic.controller;

 
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.LibraryDao;
import com.webmusic.daoimpl.PlaylistDao;
import com.webmusic.model.Library;
import com.webmusic.model.Playlist;
import com.webmusic.model.UserInfo;


@WebServlet("/addPlaylist")
public class AddPlaylist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {		
			String songTitle = req.getParameter("SongTitle");
			String playlistTitle = req.getParameter("PlaylistTitle");

			LibraryDao libDao = new  LibraryDao();
			Library lib=libDao.findSong(songTitle);
			HttpSession session = req.getSession();
			
			UserInfo premiumUser = (UserInfo) session.getAttribute("PremiumUser");
			if(premiumUser!=null) {
			Playlist playlist = new Playlist(lib, playlistTitle,premiumUser.getEmailId() );
			PlaylistDao playDao = new PlaylistDao();			
			boolean flag=playDao.insertPlaylist(playlist);
			
			if (flag) {
             
				 PlaylistDao playlistadd = new PlaylistDao();
			        List<Playlist> showPlaylist = playlistadd.showAllPlaylist();

			    	req.setAttribute("AllPlaylist",showPlaylist);
					RequestDispatcher rd=req.getRequestDispatcher("showPlaylistUser.jsp?AddedStatus=success");	
					rd.forward(req, res);
				 
				}
				else 
				{
					res.getWriter().print("Playlist is Not added");
			}
			}
			
		} catch (Exception e) {
				 e.getMessage();
			} 	
	}
}
