  <%@page import="javax.swing.text.Document"%>
<%@page import="com.webmusic.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               <%@page import="com.webmusic.model.Library"%>
    <%@page import="java.util.List"%>
            <%@page import="com.webmusic.DaoImpl.LibraryDao"%>
 


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


#nav a{
color:white;
text-decoration: none;
}

#allsongs table{
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
	height: 30px;
	font-weight: bold;
	outline: none;
	background-color:transparent;
	font-size: 18px;
	color: white;
}

#search  button {
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
        left:200px;
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
     

</style>
</head>
<body>
<body style="background-color: lightblue ">
<div id="nav">

        <ul type="none">
            
           
    
            <li><a href ="ShowSongPremium.jsp">SongList</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
              <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="AddPlaylist.jsp">Add Playlist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="AddOnUser.jsp">AddOn User</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="DeletePlaylist.jsp">DeletePlaylist</a></li>
             <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="ShowPlaylistUser.jsp"> AllPlaylist</a></li>
            <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="UpdatePUser.jsp">Update Details</a></li>
              <li>&nbsp;&nbsp;&nbsp;</li>
               <li>&nbsp;&nbsp;&nbsp;</li>
            <li><a href ="login.jsp">Logout</a></li>
        </ul>
        <div id="search">
<form action="Search" method="get" style="text-align: center;">

<input type="text" name = "Song_Title"  placeholder="Search for Music which you love..">

<button type="submit">Search</button>
</form>
</div>
    </div>
 
<div><img id="logo" src="Assets/MWlogoo.png"></div>

<%-- <% UserInfo uinfo =(UserInfo) session.getAttribute("PremiumUser");
%>
<p style="text-align: center;" id="user" >Welcome <%= uinfo.getFirstName() %></p> --%>

<%

LibraryDao libraryDao = new   LibraryDao();
List<Library> objsonglist = (List<Library>)request.getAttribute("allSongs");
objsonglist=libraryDao.showAllSongs();

 
					int count = 0;
					for (Library objbook : objsonglist) {
											
						%>
<table>
<%
int num=0;
if(num==3){
%>
<tr>
<td><%=num %></td>

<?</tr>

</table>				
 
	
			
</body>
</html>

<%-- <%!
FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
List = new ArrayList<FoodItems>();
RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
FoodItems fooditem = new FoodItems();
int restaurantid = fooditem.getRestaurant_id();
taurantdao.findRestaurantName(restaurantid);
%>
<%
foodItemList = fooditemdao.showFoodItems();
%>
<div class="table">
<table>
<tbody>
  <tr>
         <%int count=0;
         for(FoodItems showFoodItems : foodItemList){
    %>
                    <td>
                       <table id="foodtable">
                            <tbody>
                                <tr>
                                    <td><img src="image/<%=showFoodItems.getFood_image()%>" alt="foodimage"></td>    
                                    <td>
                                     <div class="names"><%=showFoodItems.getFood_name() %><br>
                                     Food Price :<%=showFoodItems.getPrice()%><br>
                                     <%=restaurantdao.findRestaurantName(showFoodItems.getRestaurant_id())%>
                                     <button><a href = "addcartserv?fname=<%=showFoodItems.getFood_name()%>&resid=<%=showFoodItems.getRestaurant_id()%>">Add to cart</a></button>
                                     </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                           
                    </td>
                       <% count ++;
                       if(count==4){ %>
                      </tr>
                      <tr>              
                     <%count=0; }}%>  
                       
                </tr>
</tbody>
</table>
</div>
</form>
</body>

 --%>