package com.webmusic.model;

import java.io.Serializable;

public class Playlist implements Serializable {
	private Library song;
	private String playlistTitle;
	private String emailId;
	@Override
	public String toString() {
		return  "\nsongId=" + song + ", playlistTitle=" + playlistTitle
				+ ", emailId=" + emailId + "\n";
	}

	
	public Library getSong() {
		return song;
	}
	public void setSong(Library song) {
		this.song = song;
	}
	public String getPlaylistTitle() {
		return playlistTitle;
	}
	public void setPlaylistTitle(String playlistTitle) {
		this.playlistTitle = playlistTitle;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Playlist() {
		super();
	}
	public Playlist( Library song, String playlistTitle, String emailId) {
		super();
		this.song = song;
		this.playlistTitle = playlistTitle;
		this.emailId = emailId;
	}
	
	
}
	