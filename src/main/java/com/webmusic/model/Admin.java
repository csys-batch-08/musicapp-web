package com.webmusic.model;


import java.util.Objects;

public class Admin {
      private String userName;
      private String password;
      private long mobileNumber;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mobileNumber, password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return mobileNumber == other.mobileNumber && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", mobileNumber=" + mobileNumber + "]";
	}
	public Admin(String userName, String password, long mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
      
 }
