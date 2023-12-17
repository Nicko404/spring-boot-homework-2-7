package com.example.springboothomework27.repository;

import com.example.springboothomework27.model.Student;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ListStudentRepository implements IStudentRepository {

    private final List<Student> students;
    private int idCounter;

    public ListStudentRepository() {
        students = new ArrayList<>();
        idCounter = 1;
    }

    @Override
    public Student addStudent(Student student) {
        student.setId(idCounter);
        idCounter++;
        students.add(student);
        return student;
    }

    @Override
    public Student deleteStudent(int id) throws IllegalArgumentException {
        Optional<Student> studentOptional = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();

        Student student = studentOptional
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat
                        .format("No Student with id = {0}.", id)));

        students.remove(student);
        return student;
    }

    @Override
    public void deleteAllStudents() {
        students.clear();
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
