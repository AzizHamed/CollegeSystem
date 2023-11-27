package com.example.CollegeSystem.service;


import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.document.Student;
import com.example.CollegeSystem.enums.Department;
import com.example.CollegeSystem.repository.StudentRepository;
import com.example.CollegeSystem.serializer.StudentGradeHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseSemesterService courseSemesterService;

    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentByFirstNameLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName).get();
    }

    public List<Student> findByDepartment(Department department) {

        return studentRepository.findByDepartment(department);
    }

    public String registerToCourseSemester(String studentId, String courseId) {
        CourseSemester courseSemester;
        Student student;

        try {
            courseSemester = courseSemesterService.findById(courseId);
        } catch (NoSuchElementException e) {
            return "course semester not found";
        }

        try {
            student = studentRepository.findById(studentId).get();
        } catch (NoSuchElementException e) {
            return "student not found";
        }

        if (courseSemester.getStudentSet().size() == courseSemester.getMaximumNumberOfStudents()) {
            courseSemester.getWaitingCourseQueue().offer(studentId);
            return "no place, student inserted to waiting list";
        }

        courseSemester.getStudentSet().add(student);
        student.getStudentGradeHashMapSet().add(new StudentGradeHashMap(studentId, courseId));
        courseSemesterService.save(courseSemester);
        studentRepository.save(student);
        return "student registered to course";

    }

    public String deleteRegistrationToCourseSemester(String studentId, String courseId) {
        Student student;
        CourseSemester courseSemester;
        try {
            student = studentRepository.findById(studentId).get();
        } catch (NoSuchElementException e) {
            return "Student not found";
        }

        try {
            courseSemester = courseSemesterService.findById(courseId);
        } catch (NoSuchElementException e) {
            return "course semester not found";
        }

        courseSemester.getStudentSet().remove(student);
        StudentGradeHashMap studentGradeHashMap;
        Iterator<StudentGradeHashMap> iterator = student.getStudentGradeHashMapSet().iterator();
        while(iterator.hasNext()){
            studentGradeHashMap = iterator.next();
            if(studentGradeHashMap.getStudentId().equals(studentId))
                student.getStudentGradeHashMapSet().remove(studentGradeHashMap);
        }
        courseSemesterService.save(courseSemester);
        studentRepository.save(student);
        return "course semester deleted from courses set";

    }

    public String enterToWaitingList(String studentId, String courseId) {
        Student student;
        CourseSemester courseSemester;

        try {
            student = studentRepository.findById(studentId).get();
        } catch (NoSuchElementException e) {
            return "Student not found";
        }

        try {
            courseSemester = courseSemesterService.findById(courseId);
        } catch (NoSuchElementException e) {
            return "course semester not found";
        }

        courseSemester.getWaitingCourseQueue().offer(studentId);
        courseSemesterService.save(courseSemester);
        return "student inserted to waiting list";
    }

    public String exitFromWaitingList(String studentId, String courseId) {
        Student student;
        CourseSemester courseSemester;

        try {
            student = studentRepository.findById(studentId).get();
        } catch (NoSuchElementException e) {
            return "Student not found";
        }

        try {
            courseSemester = courseSemesterService.findById(courseId);
        } catch (NoSuchElementException e) {
            return "course semester not found";
        }

        if(!courseSemester.getWaitingCourseQueue().contains(studentId))
            return "student is not in the waiting list";

        courseSemester.getWaitingCourseQueue().delete(studentId);
        courseSemesterService.save(courseSemester);
        return "student deleted from waiting list";

    }

    public String remove(String studentId) {
        try {
            studentRepository.delete(studentRepository.findById(studentId).get());
        }catch (NoSuchElementException e){
            return "student not found";
        }

        return "student deleted";
    }
}
