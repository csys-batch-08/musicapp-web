package com.webmusic.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.webmusic.Dao.UserPlaylistInterface;
import com.webmusic.model.UserPlaylist;
import com.webmusic.util.ConnectionUtil;


public class UserPlaylistDao implements UserPlaylistInterface {
		public void insertUserPlaylistDao() throws ClassNotFoundException, SQLException {
				
			boolean flagCheck =false;
		    
		     String userName;
		     Integer playlistId =0 ;
		     String role;
	        
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Enter userName: ");
				    userName = sc.nextLine();
				if (userName.matches("[a-z]+")&&userName!="")
				{
				
				flagCheck=false;
				}
				else
				{
				System.out.println("its invalid!!");
				flagCheck=true;
				}
				}while(flagCheck);
			
			do {
			System.out.println("Enter playlistId: ");
			
		    String	playlistId1 = sc.nextLine();
			if (playlistId1.matches("[0-9] {2}")&&playlistId1!="")
			{
				playlistId = Integer.parseInt(playlistId1);
			flagCheck=false;
			}
			else
			{
			System.out.println("its invalid!!");
			flagCheck=true;
			}
			}while(flagCheck);

			do {
				System.out.println("Enter Your Role: ");
				role = sc.nextLine();
				if (role.matches("[a-zA-Z]+")&&role!="")
				{
				//System.out.println("Your role is valid");
				flagCheck=false;
				}
				else
				{
				System.out.println("its invalid!!");
				flagCheck=true;
				}
				}while(flagCheck);

					
			UserPlaylist str = new UserPlaylist(userName,playlistId,role);
			Connection con = ConnectionUtil.getDBconnect();
			String query = " insert into playlist(user_Name, playlist_id, role)values (?,?,?)";

			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, str.getUserName());
			stmt.setInt(2, str.getPlaylistId());
			stmt.setString(3, str.getRole());
			
     		stmt.executeUpdate();
			System.out.println(" User Playlist inserted successfully");
		}



		}



