<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.webmusic.model.UserInfo"%>
    <%@page import="java.util.*"%>
            <%@page import="com.webmusic.daoimpl.UserInfoDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update premium user details</title>

    <style>
        body{
            background: url(Assets/images/markus-spiske-hU9gx8YfVK4-unsplash.jpg);
            background-size: cover;
            background-repeat: no-repeat ;
            
        }
        .signup{
            width: 400px;
            height: 400px;
            margin-left: 380px;
            margin-top: 90px ;
            padding-left: 50px;
           box-shadow: 0 0 2px 2px rgb(187, 186, 186);

        }
        th,td{
           
            padding: 5px;
        }
        #buttontable{
            margin-left: 100px;
            padding-top: 20px;
            
        }
        button{
            height: 25px;
            width: 150px;
            border: none;
            outline: none;
            
        }
        button:hover{
            background-color:rgb(109, 216, 235);
        }
        label,h2{
            color: black;
        }
        #male{
            margin-left: 0%;
            padding: 0 40px   ;
        }
        input{
            outline: none;
        }
        
                ul {
            margin: 0;
            overflow: hidden;
            background-color:black;
            color: white;
            font-weight: bolder;
            padding:30px 150px;
            opacity: 0.5px;
             position: absolute;
            top: 0px;
            left:0px;
            width: 1065px;
        }

        li {
            float: left;
            color: black;
        }


#nav a {
color:white;
text-decoration: none;
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
	height: 38px;
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

#search  button{
	position: relative;
	left: 0px;
	background-color: skyBlue;
	border: none;
	color: black;
	padding: 15px 32px;
	text-align: center;
	height: 38px;
}

::placeholder {
	color: lightblack;
	font-size: 13px;
	height: 30px;
	font-style: italic;
}

#search  ::placeholder {
	color: white;
	font-size: 13px;
	height: 30px;
	font-style: italic;
}


#allsongs table{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 2px;
        
        }
        
  
        
  #allsongs {    
        position: absolute;
        left:200px;
        }
 #img {
        
 height: 80px;
 width: 80px;
 }   
 #logo {
width:130px;
position: absolute;
left:0px;
top:-25px;
}  
         
       #addsongs{
position: absolute;
top:70px;
}
       
    </style>
</head>
<body>
<div id="nav">
        <ul type="none">     
            <li><a href ="ShowSongPremiumUser">SongList</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
              <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="addPlaylist.jsp">Add Playlist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="addOnUser.jsp">AddOn User</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeletePlaylistServlet">DeletePlaylist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="PlaylistUserServlet"> AllPlaylist</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="updatePremiumUser.jsp">Update Details</a></li>
                <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="PremiumHomeServlet">Home</a></li>       
        </ul>
        <div id="search">
<form action="Search" method="get" style="text-align: center;">
<input type="text" name = "Song_Title"  placeholder="Search for Music which you love..">
<button type="submit">Search</button>
</form>
</div>
    </div>
<div><img id="logo" src="Assets/images/MWlogoo.png" alt="could'nt load"></div>
	<form action="Update">
    <fieldset class="signup" id="addsongs">
    <legend></legend>
       <center><h3><strong>Update details here!</strong></h3></center>
        <table id="signuptable" style="border-spacing: 5px;">
        <caption></caption>
            <tr>
                <th id="fname"><label for="name">First Name:</label></th>
                <th id="fname"><input type="text" name="FirstName" id="name" value="${premiumUser.firstName}" placeholder="Enter your first name"  pattern = "[a-zA-Z]{3,30}" required autofocus></th>
            </tr>
            <tr>
                <th id="lname"><label for="name">Last Name:</label></th>
                <th id="lname"><input type="text" name="LastName" id="name" value="${premiumUser.lastName}" placeholder="Enter your last name"  pattern = "[a-zA-Z]{3,30}" required></th>
            </tr>           
            <tr>
                <th id="mailid"><label for="emailId">Email Id:</label></th>
                <th id="mailid"><input type="email" name="UserEmail" id="emailId" value="${premiumUser.emailId}" placeholder="Enter email Id" pattern = "[a-z0-9]+[@][a-z]+[.][a-z]{2,5}" required ></th>
            </tr>                   
           <tr>
                <th id="uname"><label for="name">User Name:</label></th>
                <th id="uname"><input type="text" name="UserName" id="name" value="${premiumUser.userName}" placeholder="Enter user name"  pattern ="[a-z]{2,20}" required ></th>
            </tr>                               
            <tr>
                <th id="password"><label for="password">Password:</label></th>
                <th id="password"><input type="password" name="UserPassword" id="password" value="${premiumUser.password}" placeholder="********"  pattern = "[a-zA-Z0-9@#]{5,10}" required ></th>
            </tr>          
            <tr>
                <th id="mobnum"><label for="mobile">Mobile Number:</label></th>
                <th id="mobnum"><input type="number" name="MobileNumber" id="mobile" value="${premiumUser.mobileNumber}" placeholder="Enter mobile number" pattern ="[0-9]{10}" required></th>
            </tr>            
            <tr>
                <th id="wallet"><label for="wallet">Wallet (Rs):</label></th>
                <th id="wallet"><input type="number" name="wallet" id="userwallet" value="${premiumUser.wallet}" readonly="readonly"></th>
            </tr>           
             <tr>
                <th id="subdate"><label for="subdate">Subscription Date:</label></th>
                <th id="subdate"><input type="date" name="subsDate" id="subDate" value="${premiumUser.subscription_date}"  readonly="readonly"></th>
            </tr>           
             <tr>
                <th id="expdate"><label for="expdate">Pack Expiry Date:</label></th>
                <th id="expdate"><input type="date" name="expDate" id="expdate" value="${premiumUser.expiry_date}"  readonly="readonly"></th>
            </tr>                  
        </table>     
        <table id="buttontable">
        <caption></caption>
        <th id="button">
            <tr>
                <td><button type="submit">Click to Update Details</button></td>                
            </tr>
            </th>
        </table>    
    </fieldset>
    </form>
</body>
</html>