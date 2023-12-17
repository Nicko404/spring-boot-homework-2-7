package com.example.springboothomework27.event;

import com.example.springboothomework27.model.Student;
import com.example.springboothomework27.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty("app.data.init-default-students")
@RequiredArgsConstructor
public class InitDefaultStudentsEvent {

    private final IStudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        for (int i = 0; i < 10; i++) {
            studentRepository.addStudent(Student.builder()
                    .firstname("Default" + i)
                    .lastname("default" + i)
                    .age(i)
                    .build());
        }
    }

}
