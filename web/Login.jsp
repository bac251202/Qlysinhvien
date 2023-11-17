<%-- 
    Document   : Login
    Created on : Oct 30, 2023, 6:47:20 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng Nhập</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <style>
            body {
                background-color: white;
            }
            h1 {
                
                color: black;
                text-align: center;
            }
            form {
                width: 200px;
                margin: 0 auto;
            }
            input[type="submit"] {
                background-color: red;
                color: white;
                width: 100%;
            }
        </style>
    </head>
    <body>

        <h1>Log-in</h1>
        <form action="login" method="POST">
            <% if (request.getAttribute("errorMessage") != null) {%>
            <p style="color: red;"><%= request.getAttribute("errorMessage")%></p>
            <% }%>
            <label for="username">Username:</label><br>
            <input type="text" id="username" name="username" required="required"><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required="required"><br><br>
            <input type="submit" value="Login">

        </form>
    </body>
</html>

