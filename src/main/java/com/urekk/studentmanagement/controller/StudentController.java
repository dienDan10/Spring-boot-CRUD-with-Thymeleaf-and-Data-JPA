package com.urekk.studentmanagement.controller;

import com.urekk.studentmanagement.entity.Student;
import com.urekk.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Config the InitBinder to set all Empty input String to null
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);
    }

    @GetMapping("/list")
    public String showAllStudents(Model model) {
        // get all students
        List<Student> students = studentService.findAll();
        // send to view
        model.addAttribute("students", students);
        model.addAttribute("totalStudents", students.size());
        return "student-list";
    }

    @GetMapping("/show-form")
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/process-form")
    public String processForm(@Valid @ModelAttribute("student") Student student,
                              BindingResult result) {
        // check for valid input
        if (result.hasErrors()) { // go back to form page
            return "student-form";
        }

        // save the student
        studentService.save(student);
        return "redirect:/students/list";
    }

    @GetMapping("/show-update-form")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        // get the student by id
        Student student = studentService.findById(id);
        // send to form
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("/delete")
    public String deleteStudentById(@RequestParam("id") int id) {
        studentService.deleteById(id);
        return "redirect:/students/list";
    }

}
