package com.example.CollegeSystem.enums;

public enum Gender {
    Male,Female;

    @Override
    public String toString() {
        switch (this){
            case Male -> {
                return "Male";
            }

            case Female -> {
                return "Female";
            }

            default -> {
                return "unknown gender";
            }
        }
    }
}
