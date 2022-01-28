<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add song page</title>

    <style>
        body{
            background: url(Assets/markus-spiske-hU9gx8YfVK4-unsplash.jpg);
            background-size: cover;
            background-repeat: no-repeat ;
            
        }
        .playlistadd{
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
            background-color: rgb(20, 250, 123);
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
	background-color: DodgerBlue;
	border: none;
	color: white;
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
        
  #allsongs  {    
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
            <li><a href ="AddPlaylist.jsp">Add Playlist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="AddOnUser.jsp">AddOn User</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeletePlaylistServlet">DeletePlaylist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="PlaylistUserServlet"> AllPlaylist</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="UpdatePUser.jsp">Update Details</a></li>
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
 
<div><img id="logo" src="Assets/MWlogoo.png"></div>
            


	<form action="addPlaylist">
    <fieldset class="playlistadd"  id="addsongs">
    
    <br><br>
       <center><h2>Add Playlist</h2></center>
     
        <table id="signuptable" style="border-spacing: 5px;">
        
            <tr>
                <th><label for="SongTitle">Song Title:</label></th>
                <th><input type="text" name="SongTitle" id="SongTitle" placeholder="Enter Song name" required ></th>
            </tr>
       
            <tr>
                <th><label for="PlaylistTitle">Playlist Title:</label></th>
                <th><input type="text" name="PlaylistTitle" id="PlaylistTitle" placeholder="Enter playlist Title" required ></th>
            </tr>
           
   
       
        <table id="buttontable">
            <tr>
                <td><button type="submit">Click to Add Playlist</button></td> 
               
            </tr>
        </table>    
    </fieldset>
    </form>
</body>
</html>