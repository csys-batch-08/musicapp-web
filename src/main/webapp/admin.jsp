
    <%@page import="javax.swing.text.Document"%>
<%@page import="com.webmusic.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               <%@page import="com.webmusic.model.Library"%>
    <%@page import="java.util.List"%>
            <%@page import="com.webmusic.DaoImpl.LibraryDao"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
<style>
.navs{
width: 1345px;
}
.navs ul {
            margin: 0;
            overflow: hidden;
            background-color:black;
            color: white;
            font-weight: bolder;
            padding:30px 150px;
            opacity: 0.5px;
        }

     .navs li {
            float: left;
            color: black;
        }


.navs a{
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
     
 body{
   overflow-x:hidden;
   }

</style>


  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
 <body style="background-color: lightblue "> 




<div class="navs">

        <ul type="none">
            
           
    
            <li><a href ="ShowUserServlet"  class="gl">ManageUsers</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
              <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="ShowSongAdmin"  class="gl">AllSongsList</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="addSong.jsp"  class="gl">AddSong</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="updateSong.jsp"  class="gl">UpdateSong</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeleteSonglistServlet"  class="gl">ManageSongs</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="PlaylistAdminServlet" class="gl">AllPlaylist</a></li>
                 <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="login.jsp"  class="gl">Logout</a></li>
          
        </ul>
        <div id="search">
<form action="Search" method="get" style="text-align: center;">

<input type="text" name = "Song_Title"  placeholder="Search for Music which you love..">

<button type="submit">Search</button>
</form>
</div>
    </div>
 
<div><img id="logo" src="Assets/MWlogoo.png"></div>

<%-- 	
 	<br><br>
	<center>	<h2 id="songlisthead"><b>ADMIN PAGE</b></h2>  </center> --%>


<br><br>
   <center><p><h1><b>Music can change the world</b></h1><br>
                                <h2><i>-Beethoven</i></h2></p></center> 



			<table class="table table-dark table-hover" id="allsongs">
			<thead>
				<tr>
				 
					<th>Song_title</th>
          			<th>Play_Song</th>
					<th>Image_Song </th>								
					</tr>
			</thead>
			<br>
			<br>
			
						<tbody>
			        <c:forEach items="${AdminHome}" var ="HomeAdmin">
				<tr>
			
					<td>${HomeAdmin.songTitle}</td>				
					<td>
					<audio  controls>
					<source src="Assets/${HomeAdmin.songFile}" >
					</audio>
					</td>
					<td><img id="img" src="Assets/${HomeAdmin.songImage}" alt="Couldn't load"></td>
			</tr>
				</c:forEach>
					</tbody>
		           </table>
			
	
			
</body>
</html>
<script>


document.addEventListener('play', function(e){
    var audios = document.getElementsByTagName('audio');
    for(var i = 0, len = audios.length; i < len;i++){
        if(audios[i] != e.target){
            audios[i].pause();
        }
    }
}, true);
</script>

