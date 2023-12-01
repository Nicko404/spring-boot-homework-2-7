package com.example.springboothomework27.service;

import com.example.springboothomework27.model.Student;
import com.example.springboothomework27.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    public Student addStudent(String firstname, String lastname, int age) {
        return studentRepository.addStudent(Student.builder()
                .firstname(firstname)
                .lastname(lastname)
                .age(age)
                .build());
    }

    @Override
    public Student deleteStudent(int id) throws IllegalArgumentException {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
