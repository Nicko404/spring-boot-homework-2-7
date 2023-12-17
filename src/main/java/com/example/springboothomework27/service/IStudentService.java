package com.example.springboothomework27.service;


import com.example.springboothomework27.model.Student;

import java.util.List;

public interface IStudentService {

    Student addStudent(String firstname, String lastname, int age);
    Student deleteStudent(int id);
    void deleteAllStudents();
    List<Student> getAllStudents();
}
