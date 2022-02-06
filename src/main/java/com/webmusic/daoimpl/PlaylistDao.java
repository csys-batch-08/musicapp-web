package com.webmusic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webmusic.dao.PlaylistInterface;
import com.webmusic.model.Playlist;
import com.webmusic.util.ConnectionUtil;

public class PlaylistDao implements PlaylistInterface {
	// Add playlist
	public void insertPlaylist(Playlist playlist) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			LibraryDao libDao = new LibraryDao();
			int songId = libDao.findSongId(playlist.getSong().getSongTitle());
			String query = " insert into playlist( song_id,playlist_title, email_id)values (?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, songId);
			stmt.setString(2, playlist.getPlaylistTitle());
			stmt.setString(3, playlist.getEmailId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
	}

	// Find playlist
	public int findPlaylistId(String playListName) {
		String query = "select id from playlist where playlist_Title='" + playListName + "'";
		int playlistId = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = (PreparedStatement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				playlistId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return playlistId;
	}

	// List all playlist
	public List<Playlist> showAllPlaylist() {
		List<Playlist> showPlaylist = new ArrayList<>();
		String query = "select  song_Id, playlist_title, email_id, status from playlist where status='active'";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			LibraryDao libDao = new LibraryDao();
			while (rs.next()) {
				com.webmusic.model.Library song = libDao.findSong(rs.getInt(1));
				Playlist playList = new Playlist(song, rs.getString(2), rs.getString(3));
				showPlaylist.add(playList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return showPlaylist;
	}

	// Delete playlist
	public boolean deletePlaylist(String playlistTitle, String user) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String delete = "update playlist set status='" + "inActive" + "'  where playlist_title=? and email_id=? ";
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(delete);
			stmt.setString(1, playlistTitle);
			stmt.setString(2, user);
			stmt.executeUpdate();
			flag = stmt.executeUpdate() > 0;
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return flag;
	}
}
