package com.example.springboothomework27.event.listener;

import com.example.springboothomework27.event.StudentDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentDeletedEventListener {

    @EventListener
    public void listen(StudentDeletedEvent event) {
        System.out.println(MessageFormat.format("Student with id {0} deleted.", event.getStudent().getId()));
    }
}
