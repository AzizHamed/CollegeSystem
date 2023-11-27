package com.example.CollegeSystem.document;


import com.example.CollegeSystem.embaddables.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    private String instructorId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Address address;

    private Set<String> coursesId = new HashSet<>();
}
