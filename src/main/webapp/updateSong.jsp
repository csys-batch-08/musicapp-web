<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update song page</title>

<style>
body {
	background: url(Assets/images/markus-spiske-hU9gx8YfVK4-unsplash.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}

.signup {
	width: 400px;
	height: 400px;
	margin-left: 380px;
	margin-top: 90px;
	padding-left: 50px;
	box-shadow: 0 0 2px 2px rgb(187, 186, 186);
}

th, td {
	padding: 5px;
}

#buttontable {
	margin-left: 100px;
	padding-top: 20px;
}

button {
	height: 25px;
	width: 150px;
	border: none;
	outline: none;
}

button:hover {
	background-color: rgb(250, 196, 20);
}

label, h2 {
	color: black;
}

#male {
	margin-left: 0%;
	padding: 0 40px;
}

input {
	outline: none;
}

ul {
	margin: 0;
	overflow: hidden;
	background-color: black;
	color: white;
	font-weight: bolder;
	padding: 30px 150px;
	opacity: 0.5px;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 1065px;
}

li {
	float: left;
	color: black;
}

#nav a {
	color: white;
	text-decoration: none;
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
	height: 38px;
}

#search input {
	border: none;
	height: 35px;
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
	color: black;
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

#allsongs table {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2px;
}

#allsongs {
	position: absolute;
	left: 200px;
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

#addsongs {
	position: absolute;
	top: 70px;
}
h2 {
text-align: center;
}
</style>
</head>
<body>
	<div id="nav">
		<ul type="none">
			<li><a href="ShowUserServlet">ManageUsers</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="ShowSongAdmin">AllSongsList</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="addSong.jsp">AddSong</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="updateSong.jsp">UpdateSong</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="DeleteSonglistServlet">ManageSongs</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="PlaylistAdminServlet">AllPlaylist</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="AdminHomeServlet">Home</a></li>
		</ul>
		<div id="search">
			<form action="Search" method="get" style="text-align: center;">
				<label for="songdetails"></label>
				<input type="text" name="Song_Title"
					id="songdetails"
					placeholder="Search for Music which you love..">
				<button type="submit">Search</button>
			</form>
		</div>
	</div>
	<div>
		<img id="logo" src="Assets/images/MWlogoo.png" alt="Couldn't load">
	</div>
	<form action="UpdateSong" id="addsongs">
		<fieldset class="signup">
			<legend></legend>
				<h2>Update Song details here!</h2>
			<table id="signuptable" style="border-spacing: 5px;">
				<caption></caption>
				<tr>
					<th id="songid"><label for="id">Song Id:</label></th>
					<th id="songid"><input type="number" name="song_id" id="id"
						placeholder="Enter song id" required autofocus></th>
				</tr>
				<tr>
					<th id="songtitle"><label for="title">Song Title:</label></th>
					<th id="songtitle"><input type="text" name="song_title"
						id="title" placeholder="Enter song title" required autofocus></th>
				</tr>
				<tr>
					<th id="songartist"><label for="artist">Artists:</label></th>
					<th id="songartist"><input type="text" name="artists"
						id="artist" placeholder="Enter artist" required></th>
				</tr>
				<tr>
					<th id="songalbum"><label for="album">Album:</label></th>
					<th id="songalbum"><input type="text" name="album" id="album" 
					    placeholder="Enter album" required></th>
				</tr>
				<tr>
					<th id="songgenre"><label for="genre">Genre:</label></th>
					<th id="songgenre"><input type="text" name="genre" id="genre"
						placeholder="Enter genre" required></th>
				</tr>
				<tr>
					<th id="songlang"><label for="language">Language:</label></th>
					<th id="songlang"><input type="text" name="language"
						id="language" placeholder="Enter language" required></th>
				</tr>
				<tr>
					<th id="songfile"><label for="importSong">Add song to
							database:</label></th>
					<th id="songfile"><input type="file" name="addSong"
						id="importSong" required></th>
				</tr>
				<tr>
					<th id="songimg"><label for="imageSong">Add image to
							database:</label></th>
					<th id="songimg"><input type="file" name="imgSong"
						id="imageSong" required></th>
				</tr>
			</table>
			<table id="buttontable">
				<caption></caption>
				<th id="buttom">
				<tr>
					<td><button type="submit">Click to Update Details</button></td>
				</tr>
				</th>
			</table>
		</fieldset>
	</form>
</body>
</html>