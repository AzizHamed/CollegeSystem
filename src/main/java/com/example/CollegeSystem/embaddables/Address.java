package com.example.CollegeSystem.embaddables;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
public class Address {

    private String country;

    private String city;

    private String street;
}
