package com.webmusic.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmusic.DaoImpl.LibraryDao;
import com.webmusic.model.Library;


@WebServlet("/UpdateSong")
public class UpdateSongServlet extends HttpServlet {


	public void service(HttpServletRequest req, HttpServletResponse res) {

		try {
			LibraryDao updateDao = new LibraryDao();
			
			int songId = Integer.parseInt(req.getParameter("song_id"));
			System.out.println(songId);
			
			String songTitle = req.getParameter("song_title");
			System.out.println(songTitle);
			
			String artist = req.getParameter("artists");
			System.out.println(artist);
					
			String album = req.getParameter("album");
			System.out.println(album);
			
			String genre = req.getParameter("genre");
			System.out.println(genre);
            	
			String language = req.getParameter("language");
			System.out.println(language);
			
			String addSong = req.getParameter("addSong");
			System.out.println(addSong);
            		    
			String songImage=req.getParameter("imgSong");
		    System.out.println(songImage);
			Library update = new Library(songId, songTitle, artist, album, genre, language,addSong,songImage);
		    LibraryDao updt = new LibraryDao();
		    updt.update(update);
		    if(updt!=null) {
//				res.getWriter().print(" Song Details Updated.");
                res.sendRedirect("Showsong.jsp");
			}
			else 
			{
				res.getWriter().print("Not updated");
			}
		    
		    
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		
	} 
}