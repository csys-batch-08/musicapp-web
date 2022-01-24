package com.webmusic.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webmusic.Dao.LibraryInterface;
import com.webmusic.model.Library;
import com.webmusic.util.ConnectionUtil;


public class LibraryDao implements LibraryInterface{

	// Add songs by admin
	public void insertLibrary(Library str3) throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtil.getDBconnect();
		String query = " insert into library( song_id,  song_title, artists, album, genre, language,song_file,song_image)values (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setInt(1, str3.getSongId());
		stmt.setString(2, str3.getSongTitle());
		stmt.setString(3, str3.getArtists());
		stmt.setString(4, str3.getAlbum());
		stmt.setString(5, str3.getGenre());
		stmt.setString(6, str3.getLanguage());
		stmt.setString(7, str3.getSongFile());
		stmt.setString(8, str3.getSongImage());

		stmt.executeUpdate();
		System.out.println("You're added successfully");
	}

	// Show song details
	public void showSongs(Library show) throws ClassNotFoundException, SQLException {
		String query = "select*from library";
		Connection con = ConnectionUtil.getDBconnect();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("\n" + rs.getInt(1) + "\n" + rs.getString(2) + "\n" + rs.getString(3) + "\n"
					+ rs.getString(4) + "\n" + rs.getString(5) + "\n" + rs.getString(6) + "\n" + rs.getString(7));
		}

	}
    
	//Update song details
	public void update(Library up) throws ClassNotFoundException, SQLException {

		String update = "update library set  song_title=?, artists=?,album=?, genre=?, language = ?, song_file=?,song_image=? where song_id = ?";

		Connection con = ConnectionUtil.getDBconnect();
		PreparedStatement stmt = con.prepareStatement(update);

		
		stmt.setString(1, up.getSongTitle());
		stmt.setString(2, up.getArtists());
		stmt.setString(3, up.getAlbum());
		stmt.setString(4, up.getGenre());
		stmt.setString(5, up.getLanguage());
		stmt.setString(6, up.getSongFile());
		stmt.setString(7, up.getSongImage());
		stmt.setInt(8, up.getSongId());
		int res = stmt.executeUpdate();

		System.out.println(res + " is updated !!");
	}

	// Delete song
	public boolean deleteSong(String songTitle) throws ClassNotFoundException, SQLException {
		boolean flag=false;
		try {
		String delete = "update library set status= '"+"inActive"+"' where song_title=?";

		Connection con = ConnectionUtil.getDBconnect();

		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setString(1, songTitle);

		int res = stmt.executeUpdate();
		//System.out.println(res + "is deleted");
		flag= stmt.executeUpdate()>0;
		stmt.close();
		con.close();
		}
		catch(Exception e) {
			e.getMessage();
			System.out.println("something went wrong");
		}
		 return flag;
	}

	// list song details
	public List<Library> showAllSongs() {
		List<Library> songList = new ArrayList<Library>();
		String query = "select*from library where status='active'";
		Connection con = null;
		PreparedStatement stmt;
		try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Library library = new Library(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),rs.getString(8),rs.getString(9));
				songList.add(library);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return songList;
	}
     
	//search in jsp
	public List<Library> searchsongs() throws ClassNotFoundException, SQLException {
		List<Library> searchlist = new ArrayList<Library>();
		//String query = "select * from library where song_title = '"+songtitle+"' and artists = '"+artist+"' and albums ='"+albums +"' and genre ='"+genre+"'and language ='"+language+"'";
		String query = "select * from library where status='active'";
		
	    Connection	con = ConnectionUtil.getDBconnect();
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
		
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//System.out.println("song name"+rs.getString(2));
				Library library = new Library(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),rs.getString(8),rs.getString(9));
				
				searchlist.add(library);
				
			}
			System.out.println("Completed 111");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return searchlist;
	}
     

	//find song title
	public int findSongId(String name)
	{
		String query="select song_id from library where song_title='"+name+"'";
		int songId=0;
		try {
			Connection con=ConnectionUtil.getDBconnect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				songId=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return songId;	
	}
	
	// finding song title from song object
	public Library findSong(String name)
	{
		String query="select * from library where song_title='"+name+"'";
		//int songId=findSongId(name);
		Library song=null;
		try {
			Connection con=ConnectionUtil.getDBconnect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				song=new Library(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return song;	
	}
	
	// finding song Id from song object
	public Library findSong(int songId)
	{
		String query="select * from library where song_id='"+songId+"'";
		//int songId=findSongId(name);
		Library song=null;
		try {
			Connection con=ConnectionUtil.getDBconnect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				song=new Library(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return song;	
	}
	


}
	


