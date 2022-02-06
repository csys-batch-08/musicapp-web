package com.webmusic.controller;

import java.util.ArrayList;
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


	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
			
			PlaylistDao playlistDao = new PlaylistDao();
			String songTitle = req.getParameter("SongTitle");
			System.out.println(songTitle);
			

			String playlistTitle = req.getParameter("PlaylistTitle");
			System.out.println(playlistTitle);

			LibraryDao libDao = new  LibraryDao();
			Library lib=libDao.findSong(songTitle);
			HttpSession session = req.getSession();
			
			UserInfo premiumUser = (UserInfo) session.getAttribute("PremiumUser");
			if(premiumUser!=null) {
			Playlist playlist = new Playlist(lib, playlistTitle,premiumUser.getEmailId() );
			PlaylistDao playDao = new PlaylistDao();			
			playDao.insertPlaylist(playlist);
			 if(playDao!=null) {
//					res.getWriter().print("Your Playlist added.!");
                   
				 PlaylistDao playlistadd = new PlaylistDao();
			        List<Playlist> showPlaylist = new ArrayList<Playlist>();
			        showPlaylist = playlistadd.showAllPlaylist();

			    	req.setAttribute("AllPlaylist",showPlaylist);
					RequestDispatcher rd=req.getRequestDispatcher("showPlaylistUser.jsp?AddedStatus=success");	
					rd.forward(req, res);
				 
				 
//				 res.sendRedirect("PlaylistUserServlet");
				}
				else 
				{
					res.getWriter().print("Playlist is Not added");
			}
			}
			else if (premiumUser==null){
				
				UserInfo currentUser = (UserInfo) session.getAttribute("currentUser");
				Playlist playlist = new Playlist(lib, playlistTitle,currentUser.getEmailId());
				PlaylistDao playDao = new PlaylistDao();			
				playDao.insertPlaylist(playlist);
			    if(playDao!=null) {
					res.getWriter().print("Your Playlist added.!");

				}
				else 
				{
					res.getWriter().print("Playlist is Not added");
			
			}
			}
		}
			 catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		
	}

}
