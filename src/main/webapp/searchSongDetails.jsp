<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               <%@page import="com.webmusic.model.Library"%>
    <%@page import="java.util.*"%>
            <%@page import="com.webmusic.DaoImpl.LibraryDao"%>
 <%@page import="com.webmusic.model.UserInfo"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search page</title>
<style>
#allsongs table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
         text-align: center;
        padding: 10px;
        }
 #allsongs {    
        position: absolute;
        left:0px;
        }
   #img{
 height: 80px;
 width: 80px;
 }  
 </style>
 

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 
</head>
<body style="background: url(Assets/hello-i-m-nik-ZJpjMmc351s-unsplash.jpg)">



		<table class="table table-dark table-hover" id="allsongs">
			
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
				           <c:forEach items="${songname}" var ="SongSearch">
				<tr>
				
			
					
				    <td>${SongSearch.songId}</td>
					<td>${SongSearch.songTitle}</td>				
					<td>${SongSearch.artists}</td>				
					<td>${SongSearch.album}</td>
					<td>${SongSearch.genre}</td>
					<td>${SongSearch.language}</td>
				 
					<td><audio  controls>
					<source src="Assets/${SongSearch.songFile}" >
					</audio>
					</td>
					<td><img id="img" src="Assets/${SongSearch.songImage}" alt="Couldn't load"></td>
				
					
			</tr>
			      </c:forEach>
					</tbody>
		           </table>
			
	
</body>
</html>