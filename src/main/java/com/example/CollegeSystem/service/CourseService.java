package com.example.CollegeSystem.service;


import com.example.CollegeSystem.document.Course;
import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.enums.Department;
import com.example.CollegeSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course) {
       return courseRepository.save(course);
    }

    public Course findById(String courseId) {
        return courseRepository.findById(courseId).isPresent() ? courseRepository.findById(courseId).get() : null;
    }

    public List<CourseSemester> findByCreditsGE(double credits) {
        return courseRepository.findByCreditsGE(credits);
    }

    public Course findByName(String name) {
        Course course;
        try {
            course = courseRepository.findByName(name);
        }catch (NoSuchElementException e){
            return null;
        }

        return course;
    }

    public List<Course> findByDepartment(Department department) {
        return courseRepository.findByDepartment(department);
    }

    public List<Course> findByDepartments(Department[] departments) {
        return courseRepository.findByDepartments(departments);
    }

    public List<Course> findByDepartmentsWithOr(Department[] departments) {
        return courseRepository.findByDepartmentsWithOr(departments);
    }

    public Course remove(String courseId) {
        Course course;
        try{
          course =  courseRepository.findById(courseId).get();
        }catch (NoSuchElementException e){
            return null;
        }
        courseRepository.delete(course);
        return course;
    }
}
