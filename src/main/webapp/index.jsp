
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register page</title>

    <style>
       body{
            background: url(Assets/markus-spiske-hU9gx8YfVK4-unsplash.jpg);
            background-size: cover;
            background-repeat: no-repeat ;
            
        }
        .signup{
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
            background-color: rgb(92, 199, 241);
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
        
        
        .gl:hover{
            background: rgb(109, 216, 235);
            border: none;
            box-shadow: 0 0 5px  rgb(109, 216, 235);
        }
        
          a {
            color: black;
            text-decoration: none;
        }
        
          .options {
            display: flex;
            margin:  10px auto;
            flex-wrap: wrap;
            justify-content: center;
        }
        
        
    </style>
</head>
<body>

	<form action="registerweb">
    <fieldset class="signup">
       <center><h2>Registeration</h2></center>

        <table id="signuptable" style="border-spacing: 5px;">
            <tr>
                <th><label for="name">First Name:</label></th>
                <th><input type="text" name="FirstName" id="name" placeholder="Enter your first name" pattern = "[a-zA-Z]{3,30}" required autofocus></th>
            </tr>
            <tr>
                <th><label for="name">Last Name:</label></th>
                <th><input type="text" name="LastName" id="name" placeholder="Enter your last name" pattern = "[a-zA-Z]{3,30}" required ></th>
            </tr>
           
            <tr>
                <th><label for="emailId">Email Id:</label></th>
                <th><input type="email" name="UserEmail" id="emailId" placeholder="Enter email Id"  pattern = "[a-z0-9]+[@][a-z]+[.][a-z]+{2,5}" required  onkeyup="emailvalid()" ></th>
                
            </tr>
                    
           <tr>
                <th><label for="name">User Name:</label></th>
                <th><input type="text" name="UserName" id="name" placeholder="Enter user name" pattern ="[a-z]{2,20}" required ></th>
            </tr>
            
                                  
            <tr>
                <th><label for="password">Password:</label></th>
                <th><input type="password" name="UserPassword" id="password" placeholder="********" pattern = "[a-zA-Z0-9@#]{5,8}" required ></th>
            </tr>
           
   <!--          <tr>
                <th><label for="role">Role:</label></th>
                <th><input type="text" name="Role" id="name" placeholder="Enter role" pattern = "[a-zA-Z]+{2,20}"required ></th>
            </tr> -->

            <tr>
                <th><label for="mobile">Mobile Number:</label></th>
                <th><input type="number" name="MobileNumber" id="mobile" placeholder="Enter mobile number" pattern ="[0-9]{10}" required></th>
            </tr>         
        </table>
       
        <table id="buttontable">
            <tr>
                <td><button type="submit">Click to Register</button>
         <!--       <button class="gl" ><a href="login.jsp"> or LOGIN</a></button></td> -->
           
            <div class="options">
                
                <button class="gl" ><a href="login.jsp">or Login</a></button>
            </div>
               
            </tr>
        </table>  
      
    </fieldset>
    </form>
                   <div style="color: black; font-size:  49px">
                                                <center> <p id="emailresponse"></p>  </center> 
               
               </div>
    
   
<script>  
function emailvalid()  
{  
	console.log("called");
var email_id = document.getElementById("emailId").value;  
console.log(email_id);

var url="ExceptionRegister.jsp?email="+email_id;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var response=request.responseText;  
document.getElementById('emailresponse').innerHTML=response;  
}  
}  
  
</script>
    
</body>
</html>