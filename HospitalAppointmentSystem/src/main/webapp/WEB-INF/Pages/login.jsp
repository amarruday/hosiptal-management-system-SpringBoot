<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Login</title>
    <link href="css/styles.css" rel="stylesheet" />
  </head>
  <body class="bg-primary">
    
    <div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
      <main>
      
         <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6">
              <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                  <h3 class="text-center font-weight-light my-4">Login</h3>
                  <c:if test="${not empty MSG}">
                    <span class="text-center font-weight-bold my-5" style="color:red; text-align: center">${MSG}</span>
                  </c:if>
                </div>
                <div class="card-body">
                  <form id="loginForm" name="loginForm">
                    <div class="form-group">
                      <label class="small mb-1" id="usernameLabel">Username</label>
                      <input class="form-control py-4" id="username" type="text" name="username" placeholder="Enter Username"/>
                      <span class="small mb-1 " id="usernameError" style="color:red" ></span>
                    </div>
                    <div class="form-group">
                      <label class="small mb-1" for="password">Password</label>
                      <input class="form-control py-4" id="password" type="password" name="password" placeholder="Enter password" required/>
                      <span class="small mb-1"  id="passwordError" style="color:red"></span>
                    </div>
                    <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                      <a class="small" href="#"></a><a class="btn btn-primary" href="javascript:void(0)" onclick="javascript:login()">Login</a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
    <div>
    <script>
      function login()
      {
      	var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;


        if( username == "" || username == null)
      	{
      	  document.getElementById("usernameError").innerHTML = "Enter Username";
      	  document.getElementById("username").style.borderColor = "red";
      	}
      	
      	if(password == "")
      	{
      	  document.getElementById("passwordError").innerHTML = "Enter Password";
      	  document.getElementById("password").style.borderColor = "red"
      	}
      
      	if(username != null  && password != null && username != "" && password != "")
      	{
      	  document.forms["loginForm"].method = "POST";
          document.forms["loginForm"].action = "loginUser";
          document.forms["loginForm"].submit();
      	}
      }
    </script>
  </body>
</html>

