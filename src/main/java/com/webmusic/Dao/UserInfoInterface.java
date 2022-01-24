package com.webmusic.Dao;

import java.sql.SQLException;
import java.util.List;

import com.webmusic.model.UserInfo;

public interface UserInfoInterface {
	public void insertUser(UserInfo str) throws ClassNotFoundException, SQLException;
	
	public void update(UserInfo user) throws ClassNotFoundException, SQLException;
	
	public boolean delete(String userName) throws ClassNotFoundException, SQLException;
	
	public List<UserInfo> showAllUsers();
	
	public int UpdateUserWallet(UserInfo user);
	
	public int SwitchToPremium(UserInfo user);
	
	public int AddOnUser(String emailId,UserInfo user);
	
	public boolean findUserAlreadyAddOn(UserInfo user) throws ClassNotFoundException, SQLException;
	
	
}
