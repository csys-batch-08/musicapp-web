package com.webmusic.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.webmusic.Dao.LoginInterface;
import com.webmusic.model.Admin;
import com.webmusic.model.UserInfo;
import com.webmusic.util.ConnectionUtil;


public class LoginDao implements LoginInterface{
public UserInfo login(String emailId, String Password) throws ClassNotFoundException, SQLException 
{
	Connection con = ConnectionUtil.getDBconnect();
	
    String query = "select first_Name, last_Name, email_Id, user_Name, password, role, mobile_Number, user_Wallet, subscription_date, expiry_date from User_info where email_id= ? and password= ?";
		
    PreparedStatement stmt = con.prepareStatement(query);
		
    stmt.setString(1, emailId);
	stmt.setString(2, Password);
	UserInfo user=null;
	ResultSet rs = stmt.executeQuery( );
	if(rs.next())
	{
		System.out.println(rs.getLong(7));
	user=new UserInfo(rs.getString(1), rs.getString(2), rs.getString(3), 
			rs.getString(4), rs.getString(5), rs.getString(6), Long.parseLong(rs.getString(7)),Double.parseDouble(rs.getString(8)),rs.getDate(9).toLocalDate(),rs.getDate(10).toLocalDate());
	
	}
	
	
	return user;

	}

   public Admin Checkadmin(String emailId, String Password) throws SQLException, ClassNotFoundException
   {
	   
	   //String adm = "";
	    Connection con = ConnectionUtil.getDBconnect();
		
	    String query = "select first_Name, last_Name, email_Id, user_Name, password, role, mobile_Number, user_Wallet from User_info where email_id= ? and password= ? and role='admin'";
			
	    PreparedStatement stmt = con.prepareStatement(query);
			
	    stmt.setString(1, emailId);
		stmt.setString(2, Password);
			
		ResultSet rs = stmt.executeQuery( );
		Admin admin=null;
		
		if(rs.next())
		{
			System.out.println(rs.getLong(7));
		admin=new Admin(rs.getString(3), rs.getString(5), rs.getLong(7));
		}

	   
	return admin;
	   
   }



}
