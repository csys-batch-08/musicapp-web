<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Wallet recharge page</title>

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
	background-color: rgb(109, 216, 235);
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
	height: 45px;
}

#search input {
	border: none;
	height: 45px;
	font-weight: bold;
	outline: none;
	background-color: transparent;
	font-size: 18px;
	color: black;
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
h2{
text-align: center;
}
</style>
</head>
<body>
	<div id="nav">
		<ul type="none">
			<li><a href="ShowSongServlet">SongList</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="wallet.jsp">Recharge Wallet</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="switchPremium.jsp">Switch to Premium</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="updateUser.jsp">Update Details</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li><a href="UserHomeServlet">Home</a></li>
			<li>&nbsp;&nbsp;&nbsp;</li>
			<li>&nbsp;&nbsp;&nbsp;</li>
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
	<form action="recharge">
		<fieldset class="signup" id="addsongs">
			<legend></legend>
			<br>
				<h2>Recharge Wallet here!</h2>
			<table id="signuptable" style="border-spacing: 5px;">
				<caption></caption>
				<br>
				<br>
				<tr>
					<th id="emailId"><label for="emailId">Email Id:</label></th>
					<th id="emailId"><input type="email" name="UserEmail"
						id="emailId" placeholder="Enter email Id"
						pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{2,5}" required autofocus></th>
				</tr>
				<tr>
					<th id="mobile"><label for="mobile">Mobile Number:</label></th>
					<th id="mobile"><input type="number" name="MobileNumber"
						id="mobile" placeholder="Enter mobile number" pattern="[0-9]+{10}"
						required></th>
				</tr>
				<tr>
					<th id="Amount"><label for="Amount">Amount:</label></th>
					<th id="Amount"><input type="number" min="0" name="Amount"
						id="Amount" placeholder="Enter Amount" pattern="[0-9]+{10}"
						required></th>
			</table>
			<table id="buttontable">
				<caption></caption>
				<th id="button">
				<tr>
					<td><button type="submit">Recharge Wallet</button></td>
				</tr>
				</th>
			</table>
		</fieldset>
	</form>
</body>
</html>