package com.example.CollegeSystem.repository;


import com.example.CollegeSystem.document.Course;
import com.example.CollegeSystem.document.CourseSemester;
import com.example.CollegeSystem.enums.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends MongoRepository<Course,String> {

    @Query("{credits : {$gte : ?0}}")
    List<CourseSemester> findByCreditsGE(double credits);

    public Course findByName(String name);


    @Query("{departmentList : {$in : [?0]}}")
    List<Course> findByDepartment(Department department);

    @Query("{departmentList : {$all : ?0}}")
    List<Course> findByDepartments(Department[] departments);

    @Query("{departmentList : {$in : ?0}}")
    List<Course> findByDepartmentsWithOr(Department[] departments);
}
