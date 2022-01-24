<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               <%@page import="com.webmusic.model.Library"%>
    <%@page import="java.util.*"%>
            <%@page import="com.webmusic.DaoImpl.LibraryDao"%>
 <%@page import="com.webmusic.model.UserInfo"%>
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
			<%
				         List<Library> songlist  =  (List<Library>) session.getAttribute("songname");
					for (int i=0; i<songlist.size();i++) 
					{
						Library objbook = songlist.get(i);
						//System.out.println(objbook);
				%>			
						<tbody>
				         
				<tr>
				
					
					
		            <td><%= objbook.getSongId()%></td> 
					<td><%= objbook.getSongTitle()%></td>				
					<td><%= objbook.getArtists()%></td>				
					<td> <%= objbook.getAlbum()%></td>
					<td> <%= objbook.getGenre()%></td>
					<td> <%= objbook.getLanguage()%></td>
						<td>
					<audio  controls>
					<source src="Assets/<%=objbook.getSongFile() %>" >
					</audio>
					</td>
					<td><img id="img" src="Assets/<%=objbook.getSongImage() %>"></td>
					
					
					
			</tr>
					
					<%
				}
				%>
					</tbody>
		           </table>
			
	
</body>
</html>