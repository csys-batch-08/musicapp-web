<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.webmusic.model.UserInfo"%>
    <%@page import="java.util.*"%>
            <%@page import="com.webmusic.DaoImpl.UserInfoDao"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	height: 47px;
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
	height: 47px;
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
    #del{
    text-decoration: none;
    color: white;
    }      
        
</style>


  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body style="background: url(Assets/alex-padurariu-ZR48YvUpk04-unsplash.jpg)">
<div id="navs">

        <ul type="none">
            
           
    
            <li><a href ="ShowUserServlet">ManageUsers</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
              <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="ShowSongAdmin">AllSongsList</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="addSong.jsp">AddSong</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="updateSong.jsp">UpdateSong</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeleteSonglistServlet">ManageSongs</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="PlaylistAdminServlet">AllPlaylist</a></li>
              <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="AdminHomeServlet">Home</a></li>
          
        </ul>
        <div id="search">
<form action="Search" method="get" style="text-align: center;">

<input type="text" name = "Song_Title"  placeholder="Search for Music which you love..">

<button type="submit">Search</button>
</form>
</div>
    </div>
 
<div><img id="logo" src="Assets/MWlogoo.png"></div>


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
			    
				    <c:forEach items="${UserlistAdmin}" var ="Userlist">
				    <c:set var="i" value="${i+1 }"/>
			
				<tr>
		
					<td>${i}</td>
					<td>${Userlist.firstName}</td>
					<td>${Userlist.lastName}</td>
					<td>${Userlist.emailId}</td>
					<td>${Userlist.userName}</td>
					<td>${Userlist.password}</td>
					<td>${Userlist.role}</td>
					<td>${Userlist.mobileNumber}</td>
					<td>${Userlist.wallet}</td>
					<td><button class="btn btn-danger" ><a href="deleteuser?uname=${Userlist.userName}" id="del"> Delete</a></button></td>
					
					
			     </tr>
			      
			      </c:forEach>
					</tbody>
		           </table>
			

</body>
</html>
 
</body>
</html>