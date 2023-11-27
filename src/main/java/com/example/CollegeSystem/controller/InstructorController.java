package com.example.CollegeSystem.controller;


import com.example.CollegeSystem.document.Instructor;
import com.example.CollegeSystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }
}
