package com.urekk.studentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NotNull(message = "Cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]{0,20}$", message = "Please enter a valid name")
    private String firstName;

    @Column(name="last_name")
    @NotNull(message = "Cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]{0,20}$", message = "Please enter a valid name")
    private String lastName;

    @Column(name="email")
    @NotNull(message = "Cannot be empty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Please enter a valid email")
    private String email;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
