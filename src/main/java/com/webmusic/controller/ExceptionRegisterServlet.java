package com.webmusic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExceptionRegisterServlet")
public class ExceptionRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ExceptionRegisterServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		PreparedStatement ps=con.prepareStatement("select * from User_info where email_id= ?");  
		ps.setString(1, email);  
		ResultSet rs=ps.executeQuery();  
		if(rs.next())
		{
			
			PrintWriter write = response.getWriter();
			
			write.println("Email id Already Registered");
			System.out.println(email);

		}  
		}
		catch(Exception e)
		{
		
			e.printStackTrace();
			System.out.println(e);

		}  
		  
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
