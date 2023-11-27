package com.example.CollegeSystem.controller;


import com.example.CollegeSystem.document.Course;
import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.enums.Department;
import com.example.CollegeSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {


    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping("/creditsGE")
    public List<CourseSemester> findByCreditsGE(@RequestParam double credits){
        return courseService.findByCreditsGE(credits);
    }

    @GetMapping("/name")
    public Course findByName(@RequestParam String name){
        return courseService.findByName(name);
    }

    @GetMapping("/department")
    public List<Course> findByDepartment(@RequestParam Department department){
        return courseService.findByDepartment(department);
    }

    @GetMapping("/departments")
    public List<Course> findByDepartments(@RequestParam Department [] departments){
        return courseService.findByDepartments(departments);
    }

    @GetMapping("departmentsOr")
    public List<Course> findByDepartmentsWithOr(@RequestParam Department [] departments){
        return courseService.findByDepartmentsWithOr(departments);
    }

    @DeleteMapping
    public Course deleteCourse(@RequestParam String courseId){
        return courseService.remove(courseId);
    }



}
