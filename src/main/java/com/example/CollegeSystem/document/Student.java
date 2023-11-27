package com.example.CollegeSystem.document;


import com.example.CollegeSystem.embaddables.Address;
import com.example.CollegeSystem.enums.Department;
import com.example.CollegeSystem.enums.Gender;
import com.example.CollegeSystem.enums.Nationality;
import com.example.CollegeSystem.serializer.StudentGradeHashMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.*;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class Student {
    @Id
    private String id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private Address address;

    private String email;

    private String phone;

    private Gender gender;

    private Nationality nationality;

    private Date enrollmentDate;

    private Department department;

    private Set<StudentGradeHashMap> studentGradeHashMapSet = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(email, student.email) && Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phone);
    }
}
