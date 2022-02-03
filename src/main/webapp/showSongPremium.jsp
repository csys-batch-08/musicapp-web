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
<title> Premium User all songlist page</title>
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
	height: 45px;
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
	height: 45px;
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
<body>
<body style="background-color: lightblue ">
<div id="navs">

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
 
<div><img id="logo" src="Assets/images/MWlogoo.png"></div>


	<br><br>
			<h2><b><center>All Songs List</center></b></h2>
			<table class="table table-hover" id="allsongs">
			<thead>
				<tr>
				  
					<th>Song_id</th>
					<th>Song_title</th>
					<th>Artists</th>
					<th>Album</th>
					<th>Genre</th>
					<th>Language</th>
					<th>Play_Song</th>
					<th>Image_Song </th>								
					</tr>
			</thead>
			<br>
			<br>
			
				    <tbody>				  			 
                  <c:forEach items="${AllSongsPremium}" var ="SongList">
                    <%System.out.println("songlist"); %>
				<tr>

					<td>${SongList.songId}</td>
					<td>${SongList.songTitle}</td>				
					<td>${SongList.artists}</td>				
					<td>${SongList.album}</td>
					<td>${SongList.genre}</td>
					<td>${SongList.language}</td>
				 
					<td><audio  controls>
					<source src="Assets/songs/${SongList.songFile}" >
					</audio>
					</td>
					<td><img id="img" src="Assets/images/${SongList.songImage}" alt="Couldn't load"></td>
			  
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
