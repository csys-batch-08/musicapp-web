<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email = request.getParameter("email");  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
PreparedStatement ps=con.prepareStatement("select * from User_info where email_id= ?");  
ps.setString(1, email);  
ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	System.out.println("qwertyuiop");
	PrintWriter write = response.getWriter();
	System.out.println("qwerop");
	write.println("Email id Already Registered");
	System.out.println(email);

}  
}
catch(Exception e)
{
	
	System.out.println("3456789");
	e.printStackTrace();
	System.out.println(e);

}  
  
%>
</body>
</html>