package com.webmusic.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.webmusic.dao.UserInfoInterface;
import com.webmusic.model.UserInfo;
import com.webmusic.util.ConnectionUtil;

public class UserInfoDao implements UserInfoInterface {

	static final String COMMIT = "commit";

	// Add user using insert method
	public boolean insertUser(UserInfo str) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			String query = " insert into User_Info( first_name,  last_name, email_Id, user_name, password, role, mobile_number,user_wallet,subscription_date,expiry_date )values (?,?,?,?,?,?,?,?,sysdate,sysdate+30)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, str.getFirstName());
			stmt.setString(2, str.getLastName());
			stmt.setString(3, str.getEmailId());
			stmt.setString(4, str.getUserName());
			stmt.setString(5, str.getPassword());
			stmt.setString(6, "user");
			stmt.setLong(7, str.getMobileNumber());
			stmt.setDouble(8, 0);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return true;
	}

	// Update user details
	public boolean update(UserInfo user) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String update = "update user_info set first_name=?, last_name=?,user_name=?, password=?, mobile_number=? where email_id = ? ";
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(update);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getPassword());
			stmt.setLong(5, user.getMobileNumber());
			stmt.setString(6, user.getEmailId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return true;
	}

	// Delete user
	public boolean delete(String userName) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String delete = "delete from user_info where user_name=?";
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(delete);
			stmt.setString(1, userName);
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

	// List all users
	public List<UserInfo> showAllUsers() {
		List<UserInfo> userList = new ArrayList<>();
		String query = "select first_name,  last_name, email_Id, user_name, password, role, mobile_number,user_wallet, subscription_date,expiry_date  from user_info";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBconnect();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserInfo userInfo = new UserInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getLong(7), rs.getDouble(8), rs.getDate(9).toLocalDate(),
						rs.getDate(10).toLocalDate());
				userList.add(userInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt, rs);
		}
		return userList;
	}

	// Recharge Wallet
	public int UpdateUserWallet(UserInfo user) {
		String query = "update user_info set user_wallet= user_wallet + ? where email_id=? ";
		Connection con = null;
		PreparedStatement updateWallet = null;
		int i = 0;
		try {
			con = ConnectionUtil.getDBconnect();
			updateWallet = con.prepareStatement(query);
			updateWallet.setDouble(1, user.getWallet());
			updateWallet.setString(2, user.getEmailId());
			i = updateWallet.executeUpdate();
			updateWallet.executeUpdate(COMMIT);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, updateWallet);
		}
		return i;
	}

	// Switch to Premium
	public int SwitchToPremium(UserInfo user) {
		String query = "update user_info set role=?,user_wallet=user_wallet-250, subscription_date=sysdate, expiry_date=sysdate+90 where email_id=?";
		Connection con = null;
		PreparedStatement updateUser = null;
		int i = 0;
		try {
			con = ConnectionUtil.getDBconnect();
			updateUser = con.prepareStatement(query);
			updateUser.setString(1, "Premium");
			updateUser.setString(2, user.getEmailId());
			i = updateUser.executeUpdate();
			updateUser.executeUpdate(COMMIT);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, updateUser);
		}
		return i;
	}

	// Add on user to share premium account
	public int AddOnUser(String emailId, UserInfo user) {
		int i = 0;
		String updateQuery = "update user_info set role='Premium',add_on=1, subscription_date=?,expiry_date=?   where email_id=?";
		String updatePremium = "update user_info set add_on=1 where email_id='" + user.getEmailId() + "'";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setDate(1, java.sql.Date.valueOf(user.getSubscription_date()));
			pstmt.setDate(2, java.sql.Date.valueOf(user.getExpiry_date()));
			pstmt.setString(3, emailId);
			i = pstmt.executeUpdate();
			i = pstmt.executeUpdate(COMMIT);
			i = pstmt.executeUpdate(updatePremium);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pstmt);
		}
		return i;
	}

	// To find add on user already added
	public boolean findUserAlreadyAddOn(UserInfo user) {
		boolean result = false;
		String getAddOn = "select add_on from user_info where email_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			pstmt = con.prepareStatement(getAddOn);
			pstmt.setString(1, user.getEmailId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pstmt);
		}
		return result;
	}
}
