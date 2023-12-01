package com.example.springboothomework27.model;

import lombok.*;

@Data
@Builder
public class Student {

    private int id;
    private String firstname;
    private String lastname;
    private int age;
}
