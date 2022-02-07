<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.webmusic.model.Playlist"%>
<%@page import="com.webmusic.model.Library"%>
<%@page import="java.util.*"%>
<%@page import="com.webmusic.daoimpl.PlaylistDao"%>
<%@page import="com.webmusic.daoimpl.LibraryDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Users playlist page</title>


<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<style>
#allplaylist table, th, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	padding: 10px;
}

#allplaylist {
	position: absolute;
	left: 100px;
}

.navs {
	width: 1345px;
}

#navs ul {
	margin: 0;
	overflow: hidden;
	background-color: black;
	color: white;
	font-weight: bolder;
	padding: 30px 150px;
	opacity: 0.5px;
}

#navs li {
	float: left;
	color: black;
}

#navs a {
	color: white;
	text-decoration: none;
}

#allplaylist table, th, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	padding: 10px;
}

body {
	margin: 0;
	font-family: "Lato", sans-serif;
}

table.center {
	margin-left: 300px;
	margin-right: auto;
}

#search {
	position: absolute;
	top: 15px;
	right: 10px;
	border: 2px solid white;
}

#search input {
	border: none;
	height: 30px;
	font-weight: bold;
	outline: none;
	background-color: transparent;
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
	font-size: 15px;
}

::placeholder {
	color: white;
	font-size: 13px;
	height: 30px;
	font-style: italic;
}

#allplaylist table, th, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2px;
}

#allplaylist {
	position: absolute;
	left: 0px;
}

#img {
	height: 80px;
	width: 80px;
}

#logo {
	width: 130px;
	position: absolute;
	left: 0px;
	top: -25px;
}

.gl:hover {
	background: rgb(109, 216, 235);
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: lightblue">
	<div id="navs">
		<ul type="none">
			<li><a href="ShowSongPremiumUser">SongList</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="addPlaylist.jsp">Add Playlist</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="addOnUser.jsp">AddOn User</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="DeletePlaylistServlet">DeletePlaylist</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="PlaylistUserServlet"> AllPlaylist</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="updatePremiumUser.jsp">Update Details</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="PremiumHomeServlet">Home</a></li>
		</ul>
		<div id="search">
			<form action="Search" method="get" style="text-align: center;">
				<input type="text" name="Song_Title"
					placeholder="Search for Music which you love..">
				<button type="submit">Search</button>
			</form>
		</div>
	</div>
	<div>
		<img id="logo" src="Assets/images/MWlogoo.png" alt="Couldn't load">
	</div>
	<c:if test="${param.AddedStatus!=null}">
		<script>
		var toastMixin = Swal.mixin({
			toast: true,
			icon: 'success',
			title: 'General Title',
			animation: false,
			position: 'top-right',
			showConfirmButton: false,
			timer: 2500,
			timerProgressBar: true,
			didOpen: (toast) => {
			toast.addEventListener('mouseenter', Swal.stopTimer)
			toast.addEventListener('mouseleave', Swal.resumeTimer)
			}
			});

			deleted();
			function deleted(){
			toastMixin.fire({
			animation: true,
			title: 'Successfully Added'
			});
			}
			</script>
	</c:if>
	<br>
	<br>
	<h2>
		<strong><center>All Users Playlist</center></strong>
	</h2>
	<table class="table table-hover" id="allsongs">
	<caption></caption>
		<thead>
			<tr>
				<th id="s.no">S.no</th>
				<th id="songdetails">Song_Details</th>
				<th id="plname">Playlist_Name</th>
				<th id="mailid">Email_Id</th>
			</tr>
		</thead>
		<br>
		<br>
		<tbody>
			<c:forEach items="${AllPlaylist}" var="PlaylistUser">
				<c:set var="i" value="${i+1 }" />
				<%
				System.out.println("songlist");
				%>
				<tr>
					<td>${i}</td>
					<td>${PlaylistUser.song}</td>
					<td>${PlaylistUser.playlistTitle}</td>
					<td>${PlaylistUser.emailId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
</body>
</html>