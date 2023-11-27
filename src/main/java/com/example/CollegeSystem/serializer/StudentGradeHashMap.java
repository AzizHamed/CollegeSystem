package com.example.CollegeSystem.serializer;


import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.document.Student;
import lombok.Data;

@Data
public class StudentGradeHashMap {

    private String studentId;

    private String courseSemesterId;

    private int grade;

    private boolean isSucceeded;

    public StudentGradeHashMap(String studentId, String courseSemesterId) {
        this.studentId = studentId;
        this.courseSemesterId = courseSemesterId;
    }
}
