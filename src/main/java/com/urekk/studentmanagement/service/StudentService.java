package com.urekk.studentmanagement.service;

import com.urekk.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    List<Student> findAll();

    Student findById(int id);

    void deleteById(int id);

}
