package com.webmusic.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.webmusic.dao.LoginInterface;
import com.webmusic.model.Admin;
import com.webmusic.model.UserInfo;
import com.webmusic.util.ConnectionUtil;

public class LoginDao implements LoginInterface {
	public UserInfo login(String emailId, String Password) {
		Connection con = null;
		PreparedStatement stmt = null;
		UserInfo user = null;
		try {
			con = ConnectionUtil.getDBconnect();
			String query = "select first_Name, last_Name, email_Id, user_Name, password, role, mobile_Number, user_Wallet, subscription_date, expiry_date from User_info where email_id= ? and password= ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, emailId);
			stmt.setString(2, Password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), Long.parseLong(rs.getString(7)), Double.parseDouble(rs.getString(8)),
						rs.getDate(9).toLocalDate(), rs.getDate(10).toLocalDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return user;
	}

	public Admin Checkadmin(String emailId, String Password) {
		Admin admin = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnect();
			String query = "select first_Name, last_Name, email_Id, user_Name, password, role, mobile_Number, user_Wallet from User_info where email_id= ? and password= ? and role='admin'";
			stmt = con.prepareStatement(query);
			stmt.setString(1, emailId);
			stmt.setString(2, Password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				admin = new Admin(rs.getString(3), rs.getString(5), rs.getLong(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return admin;
	}
}
