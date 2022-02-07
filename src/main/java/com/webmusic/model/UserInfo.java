package com.webmusic.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserInfo implements Serializable{
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;
	private String role;
	private long mobileNumber;
	private double wallet;
	private LocalDate subscription_date;
	private LocalDate expiry_date;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public double getWallet() {
		return wallet;
	}
	public LocalDate getSubscription_date() {
		return subscription_date;
	}
	public void setSubscription_date(LocalDate subscription_date) {
		this.subscription_date = subscription_date;
	}
	public LocalDate getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailId, firstName, lastName, mobileNumber, password, role, userName, wallet);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && mobileNumber == other.mobileNumber
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(userName, other.userName)
				&& Double.doubleToLongBits(wallet) == Double.doubleToLongBits(other.wallet);
	}
	public UserInfo(String firstName, String lastName, String emailId, String userName, String password, String role,
			long mobileNumber, double wallet, LocalDate subscription_date, LocalDate expiry_date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
		this.subscription_date = subscription_date;
		this.expiry_date = expiry_date;
	}
	@Override
	public String toString() {
		return "UserInfo [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", userName="
				+ userName + ", password=" + password + ", role=" + role + ", mobileNumber=" + mobileNumber
				+ ", wallet=" + wallet + "]";
	}
	public UserInfo(String firstName, String lastName, String emailId, String userName, String password, String role,
			long mobileNumber, double wallet) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
	}
	public UserInfo() {
		super();
	}
	
	
}