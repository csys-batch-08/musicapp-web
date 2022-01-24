package com.webmusic.model;

import java.util.Objects;

public class UserPlaylist {
      private String userName;
      private int playlistId;
      private String role;
	
      public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(playlistId, role, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPlaylist other = (UserPlaylist) obj;
		return playlistId == other.playlistId && Objects.equals(role, other.role)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "UserPlaylist [userName=" + userName + ", playlistId=" + playlistId + ", role=" + role + "]";
	}
	public UserPlaylist(String userName, int playlistId, String role) {
		super();
		this.userName = userName;
		this.playlistId = playlistId;
		this.role = role;
	}
	public UserPlaylist() {
		super();
		// TODO Auto-generated constructor stub
	}
      
}
