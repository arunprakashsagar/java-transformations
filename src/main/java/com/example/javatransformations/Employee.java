package com.example.javatransformations;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    static final long serialVersionUID = 42L;
    private int age;
    private String name;
    private transient String address;
}
