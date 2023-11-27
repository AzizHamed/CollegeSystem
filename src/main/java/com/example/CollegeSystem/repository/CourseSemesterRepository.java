package com.example.CollegeSystem.repository;


import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.enums.Semester;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSemesterRepository extends MongoRepository<CourseSemester,String> {


    public List<CourseSemester> findBySemester(Semester semester);

    public List<CourseSemester> findByYear(int year);
}
