package com.example.CollegeSystem.repository;


import com.example.CollegeSystem.document.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository  extends MongoRepository<Instructor,String> {
}
