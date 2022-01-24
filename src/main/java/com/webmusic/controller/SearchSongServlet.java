package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.DaoImpl.LibraryDao;
import com.webmusic.model.Library;
import com.webmusic.model.UserInfo;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchSongServlet
 */
@WebServlet("/Search")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session = request.getSession();
		
		try {
		String songname = request.getParameter("Song_Title");
		
		System.out.println("Completed 1"+songname);
		LibraryDao song = new LibraryDao();

	   
		 List<Library> songtitle = song.searchsongs();

		  List<Library> showList = new ArrayList<Library>();
		 
		 for(int i =0; i<songtitle.size(); i++) {
			 
			 Library search = songtitle.get(i); 
			 
		if(search.getSongTitle().equalsIgnoreCase(songname)) {
			System.out.println("song title"+search);
			showList.add(search);
		}else if(search.getArtists().equalsIgnoreCase(songname)) {
			System.out.println("song artists"+search);
			showList.add(search);
		}else if(search.getAlbum().equalsIgnoreCase(songname)) {
			System.out.println("song album"+search);
			showList.add(search);
		}else if(search.getGenre().equalsIgnoreCase(songname)) {
			System.out.println("song genre"+search);
			showList.add(search);
		}else if(search.getLanguage().equalsIgnoreCase(songname)) {
			System.out.println("song lang"+search);
			showList.add(search);
		}else
		{
			response.getWriter().print("No song found..!!!");
		}
			 for(int j=0;j<showList.size();j++) {
			 
			 Library liObj = showList.get(j);
			 System.out.println("new list : "+liObj);
			 
			 }
			 
		 }

		
		
		session.setAttribute("songname",showList );
		

		response.sendRedirect("SearchSongDetails.jsp");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
