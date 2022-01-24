package com.webmusic.Dao;

import java.sql.SQLException;
import java.util.List;

import com.webmusic.model.Playlist;

public interface PlaylistInterface {
	public void insertPlaylist(Playlist playlist) throws ClassNotFoundException, SQLException ;
	
	public int findPlaylistId(String playListName);
	
	 public List<Playlist> showAllPlaylist() ;
	 
	 public boolean deletePlaylist(String playlistTitle,String user) throws ClassNotFoundException, SQLException ;
	 
	 
}
