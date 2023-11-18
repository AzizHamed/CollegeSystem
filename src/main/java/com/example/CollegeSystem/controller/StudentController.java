package com.example.CollegeSystem.controller;


import com.example.CollegeSystem.document.Student;
import com.example.CollegeSystem.enums.Department;
import com.example.CollegeSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student postStudent(@RequestBody Student student){
        return studentService.postStudent(student);
    }

    @GetMapping("/name")
    public Student getStudentByFirstNameLastName(@RequestParam String firstName, @RequestParam String lastName){
        return studentService.getStudentByFirstNameLastName(firstName,lastName);
    }

    @GetMapping("department")
    public List<Student> findStudentByDepartment(@RequestParam Department department){
        return studentService.findByDepartment(department);
    }


}
