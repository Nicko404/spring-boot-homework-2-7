package com.example.springboothomework27.event.listener;

import com.example.springboothomework27.event.StudentSavedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentSavedEventListener {

    @EventListener
    public void listen(StudentSavedEvent event) {
        System.out.println(MessageFormat.format("Student {0} saved.", event.getStudent()));
    }
}
