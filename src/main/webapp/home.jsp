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
<title>Premium User home page</title>
<style>

ul {
            margin: 0;
            overflow: hidden;
            background-color:black;
            color: white;
            font-weight: bolder;
            padding:30px 150px;
            opacity: 0.5px;
        }

        li {
            float: left;
            color: black;
        }


a {
color:white;
text-decoration: none;
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


        
  #allsongs {    
        position: absolute;
        left:400px;
        }
 #img{

        
 height: 100px;
 width: 100px;
 }   
 #logo{
width:130px;
position: absolute;
left:0px;
top:-25px;
}  
    
    #image{
position: relative;
left: 145px;

}

#image img {
            width: 60%;
            height: 200px;
        }
        .prev{
            position: absolute;
            top: 150px;
            left: 10px;
            font-size: x-large;
        }
        .next{
            position: absolute;
            top: 150px;
            right: 20px;
            font-size: x-large;
        }
        .next:hover,.prev:hover{
            height: 10x;
            background-color: gray;
        }

          .gl:hover{
            background: rgb(109, 216, 235);
           height: 10x;
        }



 #songs {
	margin-left: 45px;
	margin-top: 20px;
	line-height: 2;
	font-size: 20px;
}

#songs p {
	margin-left: 10px;
	font-weight: bold;
}

#songs button {
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

#songs button:hover {
	background-color: white;
	color: black;
}

#songs img {
	width: 350px;
	height: 280px;
	border-radius: 10px;
	box-shadow: 0 0 7px black;
}

#songdetails {
	width: 70px;
	
}
 
 
table{
margin-left:50px;
margin-right:auto;
text-align: center;
}
   
   body{
   overflow-x:hidden;
   }

</style>
</head>
<body>
<body style="background: url(Assets/images/jean-philippe-delberghe-75xPHEQBmvA-unsplash.jpg)">
<div id="nav">

        <ul type="none">
            
           
    
            <li><a href ="ShowSongPremiumUser"  class="gl">SongList</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
              <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="addPlaylist.jsp"  class="gl">Add Playlist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="addOnUser.jsp"  class="gl">AddOn User</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeletePlaylistServlet"  class="gl">DeletePlaylist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="PlaylistUserServlet"  class="gl"> AllPlaylist</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="showUserProfile"  class="gl">Update Details</a></li>
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
 <br><br>
 
 
<div><img id="logo" src="Assets/images/MWlogoo.png" alt="can't load image"></div>

 		<div id="image">

        <div class="slideshow-container">
    
            <div class="mySlides fade">
         
              <img src="Assets/images/wp9998324-ed-sheeran-album-wallpapers.jpg" style="width:80%" alt="can't load image">
            </div>
            
            
         <div class="mySlides fade">
                <img src="Assets/images/wp2009638-avicii-wallpapers.jpg" style="width:80%" alt="can't load image">
            </div>
           
          
            <div class="mySlides fade">
          
               <img src="Assets/images/unnamed.jpg" style="width:80%" alt="can't load image">
            </div>
            
            
            <div class="mySlides fade">
            
                <img src="Assets/images/AW.jpg" style="width:80%" alt="can't load image">
              </div>
              
               <div class="mySlides fade">
                <img src="Assets/images/suriya.jpg" style="width:80%" alt="can't load image">
            </div>
              
              <div class="mySlides fade">
            
                <img src="Assets/images/marshmello.jpg" style="width:80%" alt="can't load image">
              </div>
    
     
    
        
            </div>
    </div>
    
    <p style="text-align: center;" id="user" >Welcome ${PremiumUser.firstName}</p>
	
	<br><br>
			<table>
			<tbody>
				<tr>
					<c:set var="count" value="0"/>
                    <c:forEach items="${AllSongsPremium}" var ="premiumHome">
                   
					
					<td>
						<table id="songs">
							<tbody>
								<tr>
									<td><img src="Assets/images/${premiumHome.songImage}"
										alt="songimage"></td>
								</tr>
								<tr>
									<td id="songdetails">
									${premiumHome.songTitle}
									</td>
								</tr>
							<tr>
									<td id="songcontrol">
									<audio  controls>
					                <source src="Assets/songs/${premiumHome.songFile}" >
				                  	</audio>	
									</td>
								</tr>
								</tr>
							</tbody>
						</table>

                </td>
   
                 <c:set var="count" value="${count + 1}" scope="page" />
   
               
                    <c:choose>
                    <c:when test="${count==3}">
                    </tr>
                    <tr>
                    <c:set var="count" value="0"/> 
                    </c:when>
                    </c:choose>
                    </c:forEach>
                    </tr>
             
			</tbody>
		</table>
	

	
</body>
</html>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");

  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    

  slides[slideIndex-1].style.display = "block";  
  
  setTimeout(showSlides, 2500); // Change image every 2.5 seconds
}

document.addEventListener('play', function(e){
    var audios = document.getElementsByTagName('audio');
    for(var i = 0, len = audios.length; i < len;i++){
        if(audios[i] != e.target){
            audios[i].pause();
        }
    }
}, true);


</script>







