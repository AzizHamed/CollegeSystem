package com.example.CollegeSystem.service;


import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.enums.Semester;
import com.example.CollegeSystem.repository.CourseSemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseSemesterService {

    @Autowired
    private CourseSemesterRepository courseSemesterRepository;

    @Autowired
    private CourseService courseService;


    public CourseSemester findById(String courseId) {
        return courseSemesterRepository.findById(courseId).get();
    }

    public CourseSemester save(CourseSemester courseSemester) {
/*
        courseSemester.setStudentSet(new HashSet<>());
        courseSemester.setWaitingCourseQueue(new WaitingCourseQueue());
        courseSemester.setFailedStudents(new HashSet<>());*/
        //courseSemester.setGpa(0.0);

        return courseSemesterRepository.save(courseSemester);
    }

    public List<CourseSemester> findAll() {
        return courseSemesterRepository.findAll();
    }


    public List<CourseSemester> findBySemester(Semester semester) {
        return courseSemesterRepository.findBySemester(semester);
    }

    public List<CourseSemester> findByYear(int year) {
        return courseSemesterRepository.findByYear(year);
    }

    public CourseSemester delete(String courseId) {
        CourseSemester courseSemester;
        try {
            courseSemester = courseSemesterRepository.findById(courseId).get();
        }catch (NoSuchElementException e){
            return null;
        }
        courseSemesterRepository.delete(courseSemester);
        return courseSemester;
    }
}
