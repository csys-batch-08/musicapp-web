package com.webmusic.Dao;

import java.sql.SQLException;

import com.webmusic.model.Admin;
import com.webmusic.model.UserInfo;

public interface LoginInterface {
	
	public UserInfo login(String emailId, String Password) throws ClassNotFoundException, SQLException ;

	 public Admin Checkadmin(String emailId, String Password) throws SQLException, ClassNotFoundException;
}
