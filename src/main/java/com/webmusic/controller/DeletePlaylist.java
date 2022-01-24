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

/**
 * Servlet implementation class DeletePlaylist
 */
@WebServlet("/deleteplaylist")
public class DeletePlaylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlaylist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String PlaylistTitle = request.getParameter("plname");
		System.out.println("jsp "+PlaylistTitle);
		HttpSession session=request.getSession();
		UserInfo user = (UserInfo)	session.getAttribute("PremiumUser");
		
		
		PlaylistDao playlistdao = new PlaylistDao();
		//.playlistdao playlist = playlistdao.findPlaylistId(PlaylistTitle);
		
		try {
			boolean b=playlistdao.deletePlaylist(PlaylistTitle, user.getEmailId());
			if(b==true)
			{
//				response.getWriter().print("You'r playlist is deleted");
//				System.out.println(" playlist is deleted");
				response.sendRedirect("ShowPlaylistUser.jsp");
				
			}else {
				response.getWriter().print("You'r playlist is not deleted!!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
