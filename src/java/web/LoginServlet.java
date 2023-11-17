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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        if (username.equals("admin") && password.equals("admin123")) {
            // Đăng nhập thành công, chuyển hướng tới trang Thêm Sinh Viên
            response.sendRedirect("add-student.jsp");
        } else {
            // Đăng nhập thất bại, gửi thông báo lỗi về trang Đăng Nhập
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu sai.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
