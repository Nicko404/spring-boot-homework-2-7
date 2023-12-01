package com.example.springboothomework27.event;

import com.example.springboothomework27.model.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentDeletedEvent extends ApplicationEvent {

    private final Student student;
    public StudentDeletedEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
