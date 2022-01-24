<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@page import="com.webmusic.model.Library"%>
    <%@page import="java.util.List"%>
            <%@page import="com.webmusic.DaoImpl.LibraryDao"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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



</style>
</head>
<body>
<div id="image">

        <div class="slideshow-container">
    
            <div class="mySlides fade">
         
              <img src="Assets/okk3.jpg" style="width:80%">
            </div>
            <div class="mySlides fade">
            
              <img src="Assets/unnamed.jpg" style="width:80%">
            </div>
            <div class="mySlides fade">
            
              <img src="https://gos3.ibcdn.com/img-1637069665.jpg" style="width:80%">
            </div>

            <div class="mySlides fade">
            
                <img src="https://previews.123rf.com/images/goodstudio/goodstudio1904/goodstudio190400147/123962405-horizontal-banner-with-bus-riding-along-road-from-departure-point-towards-camping-at-destination-poi.jpg" style="width:80%">
              </div>

              <div class="mySlides fade">
            
                <img src="https://static.vecteezy.com/system/resources/previews/002/729/483/non_2x/flat-green-bus-design-with-isolatd-white-modern-public-bus-travel-car-concept-vector.jpg" style="width:80%">
              </div>
    
        
            </div>
    </div>




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
  
  setTimeout(showSlides, 5000); // Change image every 2 seconds
}
</script>