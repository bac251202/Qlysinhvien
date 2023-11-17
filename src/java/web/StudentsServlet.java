/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import dao.StudentsDAO;
import model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class StudentsServlet extends HttpServlet {

    private StudentsDAO studentsDAO;

    public void init() {
        studentsDAO = new StudentsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewStudentForm(request, response);
                break;
            case "/insert":
                insertStudent(request, response);
                break;
            case "/delete":
                deleteStudent(request, response);
                break;
            case "/edit":
                showEditStudentForm(request, response);
                break;
            case "/update":
                updateStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the form to add a new student
        request.getRequestDispatcher("new-student-form.jsp").forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the form and create a new student object
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String hometown = request.getParameter("hometown");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);
        student.setDepartment(department);
        student.setHometown(hometown);

        // Insert the student into the database
        studentsDAO.insertStudent(student);

        // Redirect to the student list page
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID to be deleted
        int studentId = Integer.parseInt(request.getParameter("id"));

        // Delete the student from the database
        studentsDAO.deleteStudent(studentId);

        // Redirect to the student list page
        response.sendRedirect("list");
    }

    private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID to be edited
        int studentId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the student from the database
        Student student = studentsDAO.selectStudent(studentId);

        // Set the student object as a request attribute
        request.setAttribute("student", student);

        // Display the form to edit the student
        request.getRequestDispatcher("edit-student-form.jsp").forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the form and update the student object
        int studentId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String hometown = request.getParameter("hometown");

        Student student = new Student();
        student.setId(studentId);
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);
        student.setDepartment(department);
        student.setHometown(hometown);

        // Update the student in the database
        studentsDAO.updateStudent(student);

        // Redirect to the student list page
        response.sendRedirect("list");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all students from the database
        List<Student> students = studentsDAO.selectAllStudents();

        // Set the students list as a request attribute
        request.setAttribute("students", students);

        // Display the student list page
        request.getRequestDispatcher("student-list.jsp").forward(request, response);
    }
}
