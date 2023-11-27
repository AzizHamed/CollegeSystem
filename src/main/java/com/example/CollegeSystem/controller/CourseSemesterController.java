package com.example.CollegeSystem.controller;


import com.example.CollegeSystem.document.Course;
import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.enums.Semester;
import com.example.CollegeSystem.service.CourseSemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courseSemester")
public class CourseSemesterController {

    @Autowired
    private CourseSemesterService courseSemesterService;

    @PostMapping
    public CourseSemester saveCourseSemester(@RequestBody CourseSemester courseSemester){
        return courseSemesterService.save(courseSemester);
    }

    @GetMapping
    public List<CourseSemester> findAll(){
        return courseSemesterService.findAll();
    }

    @GetMapping("/semester")
    public List<CourseSemester> findBySemester(@RequestParam Semester semester){
        return courseSemesterService.findBySemester(semester);
    }

    @GetMapping("/year")
    public List<CourseSemester> findByYear(@RequestParam int year){
        return courseSemesterService.findByYear(year);
    }

    @DeleteMapping
    public CourseSemester deleteCourseSemester(@RequestParam String courseId){
        return courseSemesterService.delete(courseId);
    }




}
