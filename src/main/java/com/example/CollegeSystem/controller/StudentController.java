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

    @GetMapping("/department")
    public List<Student> findStudentByDepartment(@RequestParam Department department){
        return studentService.findByDepartment(department);
    }

    @PutMapping("/register")
    public String registerToCourseSemester(@RequestParam String studentId, @RequestParam String courseId){
        return studentService.registerToCourseSemester(studentId,courseId);
    }

    @PutMapping("/deleteRegistration")
    public String deleteRegistrationToCourseSemester(String studentId,String courseId){
        return studentService.deleteRegistrationToCourseSemester(studentId,courseId);
    }

    @PutMapping("/enterToWaitingList")
    public String enterToWaitingList(@RequestParam String studentId, @RequestParam String courseId){
        return studentService.enterToWaitingList(studentId,courseId);
    }

    @PutMapping("/exitFromWaitingList")
    public String exitFromWaitingList(@RequestParam String studentId, @RequestParam String courseId){
        return studentService.exitFromWaitingList(studentId,courseId);
    }

    @DeleteMapping()
    public String deleteStudent(@RequestParam String studentId){
        return studentService.remove(studentId);
    }



}
