package com.example.springboothomework27;

import com.example.springboothomework27.event.StudentDeletedEvent;
import com.example.springboothomework27.event.StudentSavedEvent;
import com.example.springboothomework27.model.Student;
import com.example.springboothomework27.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.text.MessageFormat;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class StudentAccountingShell {

    private final IStudentService studentService;
    private final ApplicationEventPublisher publisher;

    @ShellMethod(key = "add")
    public void addStudent(@ShellOption(value = "fn") String firstname,
                             @ShellOption(value = "ln") String lastname,
                             @ShellOption(value = "a") int age) {
        Student student = studentService.addStudent(firstname, lastname, age);
        publisher.publishEvent(new StudentSavedEvent(this, student));
    }

    @ShellMethod(key = "showAll")
    public String showAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students.isEmpty() ? "No saved students." : MessageFormat.format("All saved students:\n{0}",
                listStudentsToString(students));
    }

    @ShellMethod(key = "deleteById")
    public void deleteStudentById(int id) {
        try {
            Student student = studentService.deleteStudent(id);
            publisher.publishEvent(new StudentDeletedEvent(this, student));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    @ShellMethod(key = "deleteAll")
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "All students has been deleted.";
    }

    private String listStudentsToString(List<Student> students) {
        StringBuilder builder = new StringBuilder();
        students.forEach(student -> {
            builder.append(student);
            builder.append("\n");
        });
        return builder.toString();
    }

}
