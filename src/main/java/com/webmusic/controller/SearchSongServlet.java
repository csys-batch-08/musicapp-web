package com.webmusic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmusic.daoimpl.LibraryDao;
import com.webmusic.model.Library;
import com.webmusic.model.UserInfo;
import javax.servlet.http.HttpSession;

@WebServlet("/Search")
public class SearchSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			String songname = request.getParameter("Song_Title");
			LibraryDao song = new LibraryDao();
			List<Library> songtitle = song.searchsongs();
			List<Library> showList = new ArrayList<>();

			for (int i = 0; i < songtitle.size(); i++) {
				Library search = songtitle.get(i);

				if (search.getSongTitle().equalsIgnoreCase(songname)) {
					showList.add(search);
				} else if (search.getArtists().equalsIgnoreCase(songname)) {
					showList.add(search);
				} else if (search.getAlbum().equalsIgnoreCase(songname)) {
					showList.add(search);
				} else if (search.getGenre().equalsIgnoreCase(songname)) {
					showList.add(search);
				} else if (search.getLanguage().equalsIgnoreCase(songname)) {
					showList.add(search);
				} else {
					response.getWriter().print("No song found..!!!");
				}
				for (int j = 0; j < showList.size(); j++) {
					Library liObj = showList.get(j);
				}
			}

			session.setAttribute("songname", showList);
			RequestDispatcher rd = request.getRequestDispatcher("searchSongDetails.jsp");
			rd.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
