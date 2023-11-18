package com.example.CollegeSystem.service;


import com.example.CollegeSystem.document.Student;
import com.example.CollegeSystem.enums.Department;
import com.example.CollegeSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentByFirstNameLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName,lastName).get();
    }

    public List<Student> findByDepartment(Department department) {

        return studentRepository.findByDepartment(department);
    }
}
