package com.webmusic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webmusic.dao.LibraryInterface;
import com.webmusic.model.Library;
import com.webmusic.util.ConnectionUtil;

public class LibraryDao implements LibraryInterface {

	// Add songs by admin
	public boolean insertLibrary(Library str3) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			String query = " insert into library( song_id,  song_title, artists, album, genre, language,song_file,song_image)values (?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, str3.getSongId());
			stmt.setString(2, str3.getSongTitle());
			stmt.setString(3, str3.getArtists());
			stmt.setString(4, str3.getAlbum());
			stmt.setString(5, str3.getGenre());
			stmt.setString(6, str3.getLanguage());
			stmt.setString(7, str3.getSongFile());
			stmt.setString(8, str3.getSongImage());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return true;
	}


	// Update song details
	public boolean update(Library up) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String update = "update library set  song_title=?, artists=?,album=?, genre=?, language = ?, song_file=?,song_image=? where song_id = ?";
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(update);
			stmt.setString(1, up.getSongTitle());
			stmt.setString(2, up.getArtists());
			stmt.setString(3, up.getAlbum());
			stmt.setString(4, up.getGenre());
			stmt.setString(5, up.getLanguage());
			stmt.setString(6, up.getSongFile());
			stmt.setString(7, up.getSongImage());
			stmt.setInt(8, up.getSongId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return true;
	}

	// Delete song
	public boolean deleteSong(String songTitle) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String delete = "update library set status= '" + "inActive" + "' where song_title=?";
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(delete);
			stmt.setString(1, songTitle);
			flag = stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return flag;
	}

	// list song details
	public List<Library> showAllSongs() {
		List<Library> songList = new ArrayList<>();
		String query = "select song_id,  song_title, artists, album, genre, language, status, song_file, song_image from library where status='active'";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Library library = new Library(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(8), rs.getString(9));
				songList.add(library);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return songList;
	}

	// search in jsp
	public List<Library> searchsongs() {
		List<Library> searchlist = new ArrayList<>();
		String query = "select song_id,  song_title, artists, album, genre, language, status, song_file, song_image from library where status='active'";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Library library = new Library(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(8), rs.getString(9));
				searchlist.add(library);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return searchlist;
	}

	// find song title
	public int findSongId(String name) {
		String query = "select song_id from library where song_title=?";
		int songId = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				songId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return songId;
	}

	// finding song title from song object
	public Library findSong(String name) {
		String query = "select song_id,  song_title, artists, album, genre, language from library where song_title=?";
		Library song = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				song = new Library(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return song;
	}

	// finding song Id from song object
	public Library findSong(int songId) {
		String query = "select song_id,  song_title, artists, album, genre, language from library where song_id=?";
		Library song = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, songId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				song = new Library(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return song;
	}
}
