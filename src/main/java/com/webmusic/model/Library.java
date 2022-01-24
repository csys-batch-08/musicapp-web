package com.webmusic.model;


import java.util.Date;
import java.util.Objects;

public class Library {
	 private int songId;
	 private String songTitle;
	 private String artists;
	 private String album;
	 private String genre;
	 private String language;
	 private String songFile;
	 private String songImage;

	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	
	public String getArtists() {
		return artists;
	}
	public void setArtists(String artists) {
		this.artists = artists;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public String getSongFile() {
		return songFile;
	}
	public void setSongFile(String songFile) {
		this.songFile = songFile;
	}
	public String getSongImage() {
		return songImage;
	}
	public void setSongImage(String songImage) {
		this.songImage = songImage;
	}
	@Override
	public String toString() {
		return "\nsongId=" + songId + ", songTitle=" + songTitle + ", artists="
				+ artists + ", album=" + album + ", genre=" + genre + ", language=" + language + "\n";
	}
	public Library(int songId, String songTitle, String artists, String album, String genre,
			String language) {
		super();
		this.songId = songId;
		this.songTitle = songTitle;
		this.artists = artists;
		this.album = album;
		this.genre = genre;
		this.language = language;
		
	}
	public Library(int songId, String songTitle, String artists, String album, String genre, String language,
			String songFile, String songImage) {
		super();
		this.songId = songId;
		this.songTitle = songTitle;
		this.artists = artists;
		this.album = album;
		this.genre = genre;
		this.language = language;
		this.songFile = songFile;
		this.songImage = songImage;
	}
	public Library(int songId, String songTitle, String artists, String album, String genre, String language,
			String songFile) {
		super();
		this.songId = songId;
		this.songTitle = songTitle;
		this.artists = artists;
		this.album = album;
		this.genre = genre;
		this.language = language;
		this.songFile = songFile;
	}
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
