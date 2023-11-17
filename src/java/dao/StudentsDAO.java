/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
public class StudentsDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/qlysinhvien";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students (name, age, phone, email, department, hometown) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STUDENTS_BY_ID = "SELECT * FROM students WHERE id = ?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String DELETE_STUDENTS_SQL = "DELETE FROM students WHERE id = ?";
    private static final String UPDATE_STUDENTS_SQL = "UPDATE students SET name = ?, age = ?, phone = ?, email = ?, department = ?, hometown = ? WHERE id = ?";

    public StudentsDAO() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertStudent(Student student) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getDepartment());
            preparedStatement.setString(6, student.getHometown());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student selectStudent(int studentId) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_ID)) {
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String department = resultSet.getString("department");
                String hometown = resultSet.getString("hometown");
                student = new Student(studentId, name, age, phone, email, department, hometown);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String department = resultSet.getString("department");
                String hometown = resultSet.getString("hometown");
                Student student = new Student(id, name, age, phone, email, department, hometown);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void deleteStudent(int studentId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_SQL)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getDepartment());
            preparedStatement.setString(6, student.getHometown());
            preparedStatement.setInt(7, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
