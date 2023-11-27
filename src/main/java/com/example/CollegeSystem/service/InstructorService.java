package com.example.CollegeSystem.service;


import com.example.CollegeSystem.document.Instructor;
import com.example.CollegeSystem.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}
