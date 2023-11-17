<%-- 
    Document   : student-list
    Created on : Oct 30, 2023, 6:48:06 PM
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
   <body>
    <h1>Danh sách Sinh Viên</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Tuổi</th>
                <th>Số Điện Thoại</th>
                <th>Email</th>
                <th>Bộ Phận</th>
                <th>Quê Quán</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.phone}</td>
                    <td>${student.email}</td>
                    <td>${student.department}</td>
                    <td>${student.hometown}</td>
                    <td>
                        <a href="edit?id=${student.id}">Sửa</a>
                        <a href="delete?id=${student.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="new">Thêm Sinh Viên mới</a>
</body>
</html>