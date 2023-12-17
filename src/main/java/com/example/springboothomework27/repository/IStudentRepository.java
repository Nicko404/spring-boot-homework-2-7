package com.example.springboothomework27.repository;

import com.example.springboothomework27.model.Student;

import java.util.List;

public interface IStudentRepository {

    Student addStudent(Student student);
    Student deleteStudent(int id);
    void deleteAllStudents();
    List<Student> getAllStudents();
}
