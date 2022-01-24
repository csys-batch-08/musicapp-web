<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.webmusic.model.UserInfo"%>
    <%@page import="java.util.*"%>
            <%@page import="com.webmusic.DaoImpl.UserInfoDao"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users list page</title>
<style>
     
      .navs{
width: 1345px;
}
#navs ul {
            margin: 0;
            overflow: hidden;
            background-color:black;
            color: white;
            font-weight: bolder;
            padding:30px 150px;
            opacity: 0.5px;
        }

     #navs li {
            float: left;
            color: black;
        }


#navs a{
color:white;
text-decoration: none;
}

#allsongs table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
         text-align: center;
        padding: 10px;
        }
       body {
  margin: 0;
  font-family: "Lato", sans-serif;
}


table.center{
margin-left:300px;
margin-right:auto;
}
 #search {
	position: absolute;
	top: 15px;
	right:10px;
	border:2px solid white;
}

#search input {
	border: none;
	height: 30px;
	font-weight: bold;
	outline: none;
	background-color:transparent;
	font-size: 18px;
	color: white;
}

#search  button {
	position: relative;
	left: 0px;
	background-color: skyBlue;
	border: none;
	color: black;
	padding: 15px 32px;
	text-align: center;
	height: 38px;
	font-family: bold;
	font-size:15px;
}

::placeholder {
	color: white;
	font-size: 13px;
	height: 30px;
	font-style: italic;
}

#allsongs table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 2px;
        
        }
        
  #allsongs {    
        position: absolute;
        left:0px;
        }
 #img{

        
 height: 80px;
 width: 80px;
 }   
 #logo{
width:130px;
position: absolute;
left:0px;
top:-25px;
}  
     .gl:hover{
            background: rgb(109, 216, 235);
           
        }
          
        
</style>


  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body style="background: url(Assets/alex-padurariu-ZR48YvUpk04-unsplash.jpg)">
<div id="navs">

        <ul type="none">
            
           
    
            <li><a href ="ShowUsers.jsp">ManageUsers</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
              <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="Showsong.jsp">AllSongsList</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="AddSong.jsp">AddSong</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="UpdateSong.jsp">UpdateSong</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeleteSong.jsp">ManageSongs</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="ShowPlaylist.jsp">AllPlaylist</a></li>
              <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="Admin.jsp">Home</a></li>
          
        </ul>
        <div id="search">
<form action="Search" method="get" style="text-align: center;">

<input type="text" name = "Song_Title"  placeholder="Search for Music which you love..">

<button type="submit">Search</button>
</form>
</div>
    </div>
 
<div><img id="logo" src="Assets/MWlogoo.png"></div>


		
		<!-- 
		<table border="2" id="allusers"> -->
		<br><br>
			<h1><b><center>Manage Users</center></b></h1>
			<table class="table table-dark table-hover" id="allsongs">
			<thead>
				<tr>
				   <th >S.no</th>
					<th>First_Name</th>
					<th>Last_Name</th>
					<th>Email_Id</th>
					<th>User_Name</th>
					<th>Password</th>
					<th>Role</th>
					<th>Mobile_Number</th>
					<th>Wallet</th>
					<th>DeleteUser</th>
					</tr>
			</thead>
			<br>
			<br>
			
						<tbody>
				<%
					
						
				UserInfoDao UserInfoDao = new UserInfoDao();
				        List<UserInfo> userList = new ArrayList<UserInfo>();
				        userList = UserInfoDao.showAllUsers();

						
				for (int i = 0; i<userList.size(); i++){
					UserInfo userinfo = userList.get(i);
					int j=i+1;
				%>
				<tr>
				
					
					<td><%=j%></td>
					<td><%=userinfo.getFirstName()%></td>
					<td><%=userinfo.getLastName()%></td>				
					<td><%=userinfo.getEmailId()%></td>				
					<td> <%=userinfo.getUserName()%></td>
					<td> <%=userinfo.getPassword()%></td>
					<td> <%=userinfo.getRole()%></td>
					<td> <%=userinfo.getMobileNumber()%></td>
					<td> <%=userinfo.getWallet()%></td>
					<td> <a href="deleteuser?uname=<%=userinfo.getUserName()%>" %>Delete</a>
					
					
			</tr>
					
					<%
				}
				%>
					</tbody>
		           </table>
			

</body>
</html>
 
</body>
</html>