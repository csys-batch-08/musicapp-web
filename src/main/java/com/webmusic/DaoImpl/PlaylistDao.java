package com.webmusic.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



import com.webmusic.Dao.PlaylistInterface;
import com.webmusic.model.Playlist;
import com.webmusic.model.UserInfo;
import com.webmusic.util.ConnectionUtil;


public class PlaylistDao implements PlaylistInterface{
	// Add playlist
	public void insertPlaylist(Playlist playlist) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionUtil.getDBconnect();
		LibraryDao libDao=new LibraryDao();
		int songId=libDao.findSongId(playlist.getSong().getSongTitle());
		String query = " insert into playlist( song_id,playlist_title, email_id)values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, songId);
		stmt.setString(2, playlist.getPlaylistTitle());
		stmt.setString(3,playlist.getEmailId());
		
		System.out.println(stmt.executeUpdate()>0?"Playlist inserted successfully":"Playlist not updated");
	}
	
	// Find playlist
	public int findPlaylistId(String playListName)
	{
		String query="select id from playlist where playlist_Title='"+playListName+"'";
//		String JoinPlaylist = "";
		int playlistId=0;
		try {
			Connection con=ConnectionUtil.getDBconnect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				playlistId=rs.getInt(1);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return playlistId;	
	}
	
	// List all playlist
	 public List<Playlist> showAllPlaylist() 
     {
	    List<Playlist> showPlaylist = new ArrayList<Playlist>();
     String query ="select * from playlist where status='active'";
     Connection con=null;
     PreparedStatement stmt;
     try {
			con = ConnectionUtil.getDBconnect();
     	 stmt =con.prepareStatement(query);
			 ResultSet rs=stmt.executeQuery();
			 LibraryDao libDao=new LibraryDao();
			 while(rs.next())
			 {
				 com.webmusic.model.Library song=libDao.findSong(rs.getInt(1));
				 Playlist  playList = new Playlist(song, rs.getString(3),rs.getString(4));
				 showPlaylist.add(playList);
			 }
			 
     }catch(SQLException e) {
     	
     	e.printStackTrace();
     } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showPlaylist;
}
	 
	 // Delete playlist
	 public boolean deletePlaylist(String playlistTitle,String user) throws ClassNotFoundException, SQLException {
		 boolean flag=false;
		 try {
			String delete = "update playlist set status='"+"inActive"+"'  where playlist_title=? and email_id=? ";
		
			Connection con = ConnectionUtil.getDBconnect();

			PreparedStatement stmt = con.prepareStatement(delete);
			System.out.println(playlistTitle);
			System.out.println(user);
			stmt.setString(1, playlistTitle);
			stmt.setString(2, user);
           
			int res = stmt.executeUpdate();
			System.out.println(res + "is updated");
			flag= stmt.executeUpdate()>0;
			stmt.close();
			con.close();
		 }catch(Exception e) {
				e.getMessage();
				System.out.println("something went wrong");
			}
			return flag;


	}
}

