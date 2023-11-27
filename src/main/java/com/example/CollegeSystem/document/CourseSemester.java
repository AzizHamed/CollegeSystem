package com.example.CollegeSystem.document;

import com.example.CollegeSystem.enums.Semester;
import com.example.CollegeSystem.serializer.WaitingCourseQueue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "course_semester")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class CourseSemester {

    @Id
    private String courseSemesterId;

    @NonNull
    private String courseId;

    @NonNull
    private Semester semester;

    @NonNull
    private int year;

    private Set<Instructor> instructors = new HashSet<>();

    private Set<Student> studentSet = new HashSet<>();

    @NonNull
    private int maximumNumberOfStudents;

    private double gpa;

    private Set<Student> failedStudents = new HashSet<>();

    private WaitingCourseQueue waitingCourseQueue = new WaitingCourseQueue();




}
