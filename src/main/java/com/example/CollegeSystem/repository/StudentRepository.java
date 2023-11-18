package com.example.CollegeSystem.repository;


import com.example.CollegeSystem.document.Student;
import com.example.CollegeSystem.enums.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    @Query("{firstName : ?0 ,lastName : ?1}")
    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByDepartment(Department department);
}
