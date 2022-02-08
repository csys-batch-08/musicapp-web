package com.webmusic.dao;

import java.sql.SQLException;
import java.util.List;

import com.webmusic.model.Library;

public interface LibraryInterface {
	
	public boolean insertLibrary(Library str3) throws ClassNotFoundException, SQLException;
	
	public boolean update(Library up) throws ClassNotFoundException, SQLException;
	
	public boolean deleteSong(String songTitle) throws ClassNotFoundException, SQLException;
	
	public List<Library> showAllSongs();
	
	public List<Library> searchsongs() throws ClassNotFoundException, SQLException;
	
	public int findSongId(String name);
	
	public Library findSong(String name);
	
	public Library findSong(int songId);
	
}
