package com.urekk.studentmanagement.serviceImpl;

import com.urekk.studentmanagement.entity.Student;
import com.urekk.studentmanagement.repository.StudentRepository;
import com.urekk.studentmanagement.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
