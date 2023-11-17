<%-- 
    Document   : add-student
    Created on : Oct 30, 2023, 6:47:40 PM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Sinh Viên</title>
</head>
<body>
    <h1>Danh sách Sinh Viên</h1>
    <form action="insert" method="post">
        <label for="name">Tên Sinh Viên:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Tuổi Sinh Viên:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="phone">Số Điện Thoại:</label>
        <input type="text" id="phone" name="phone" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="department">Bộ Phận:</label>
        <input type="text" id="department" name="department" required><br>

        <label for="hometown">Quê Quán:</label>
        <input type="text" id="hometown" name="hometown" required><br>

        <input type="submit" value="Save">
    </form>
</body>
</html>