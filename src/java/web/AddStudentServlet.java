/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin sinh viên từ request
        String studentName = request.getParameter("studentName");
        int studentAge = Integer.parseInt(request.getParameter("studentAge"));
        String studentPhone = request.getParameter("studentPhone");
        String studentEmail = request.getParameter("studentEmail");
        String studentDepartment = request.getParameter("studentDepartment");
        String studentHometown = request.getParameter("studentHometown");

        // Lưu thông tin sinh viên vào cơ sở dữ liệu hoặc danh sách sinh viên
        // Chuyển hướng tới trang Danh sách Sinh Viên
        response.sendRedirect("student-list.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
