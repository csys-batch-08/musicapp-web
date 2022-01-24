
	  <%@page import="javax.swing.text.Document"%>
<%@page import="com.webmusic.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               <%@page import="com.webmusic.model.Library"%>
    <%@page import="java.util.List"%>
            <%@page import="com.webmusic.DaoImpl.LibraryDao"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/aeca6704b2.js"
	crossorigin="anonymous"></script>
<style type="text/css">
@charset "ISO-8859-1";

* {
	margin: 0;
	padding: 0;
	color: white;
}

body {
	background-image: linear-gradient(rgba(0, 0, 0, .5) 50%,
		rgb(0, 0, 0, .5) 50%), url("./Images/background.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
}

.navigation {
	padding-top: 15px;
	font-family: sans-serif;
}

h1 {
	display: inline;
	width: 300px;
	position: absolute;
	top: 10px;
	left: 10px;
	font-size: 25px;
}

#searchinput {
	padding-left: 10px;
	position: absolute;
	font-size: 17px;
	top: 13px;
	left: 230px;
	width: 300px;
	height: 30px;
	border: 1px solid;
	border-color: tomato;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
	background-color: transparent;
	border-right: none;
}

#searchinput::placeholder {
	color: white;
}

#search {
	position: absolute;
	left: 530px;
	width: 100px;
	height: 30px;
	margin-top: -2px;
	border: 1px solid;
	border-color: tomato;
	font-size: 17px;
	font-weight: bold;
	border-top-right-radius: 10px;
	border-left: none;
	background-color: tomato;
}

#search:hover {
	background-color: white;
	border-color: white;
	color: black;
}

#menu li {
	display: inline;
}

#menu a {
	float: right;
	padding-right: 20px;
	margin-top: 2px;
	font-size: 20px;
	font-weight: bold;
	text-decoration: none;
	transition: 0.5s;
	font-weight: bold;
}

#menu a:hover {
	color: black;
}

.petlist {
	margin-top: 40px;
	padding-top: 20px;
	margin-left: 50px;
	transition: 0.5s;
}

.petlist:hover {
	color: black;
}

.content h2 {
	margin-top: 30px;
	width: 150px;
	font-size: 30px;
}

#pets {
	margin-left: 45px;
	margin-top: 20px;
	line-height: 2;
	font-size: 20px;
}

#pets p {
	margin-left: 10px;
	font-weight: bold;
}

#pets button {
	margin-left: 10px;
	margin-top: 5px;
	width: 120px;
	height: 30px;
	background-color: rgb(16, 177, 16);
	border-radius: 10px;
	border: none;
	color: white;
	font-size: 17px;
	font-weight: bold;
	box-shadow: 0 0 5px black;
}

#pets button:hover {
	background-color: white;
	color: black;
}

#pets img {
	width: 350px;
	height: 280px;
	border-radius: 10px;
}

#petdetails {
	width: 70px;
}

input:focus {
	outline: none;
}
</style>
</head>
<body>

	<%
	LibraryDao libraryDao = new   LibraryDao();
	List<Library> objsonglist = (List<Library>)request.getAttribute("allSongs");
	objsonglist=libraryDao.showAllSongs();
%>

	
		<table>
			<tbody>
				<tr>
					<%
					int count = 0;
					for (Library library : objsonglist) {
					%>
					<td>
						<table id="pets">
							<tbody>
								<tr>
									<td><img src="<%=library.getSongImage()%>"
										alt="petimage"></td>
								</tr>
								<tr>
									<td id="petdetails">
									<%=	library.getSongTitle() %>
									</td>
								</tr>
								<tr>
									<td>
									<audio  controls>
					                <source src="Assets/<%=library.getSongFile() %>" >
				                  	</audio>	
									</td>
								</tr>
							</tbody>
						</table>


					</td>
					<%
					count++;
					if (count == 3) {
					%>
				</tr>
				<tr>
					<%
					count = 0;
					}
					}
					%>

				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
</html>

