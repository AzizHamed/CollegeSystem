package com.example.CollegeSystem.document;

import com.example.CollegeSystem.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.*;

@Document
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
public class Course {

    @Id
    private String courseId;

    @NonNull
    private String name;


    @NonNull
    private Set<Department> departmentList = new HashSet<>();

    @NonNull
    private double credits;


    private Set<String> prerequisites = new HashSet<>();

}
