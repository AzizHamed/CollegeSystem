package com.example.CollegeSystem.enums;


public enum Semester {
    Winter,Summer,Spring;

    @Override
    public String toString() {
        switch (this){
            case Summer -> {
                return "Summer";
            }

            case Winter -> {
                return "Winter";
            }

            case Spring -> {
                return "Spring";
            }

            default -> {
                return "unknown semester";
            }
        }
    }
}
