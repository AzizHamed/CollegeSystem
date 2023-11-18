package com.example.CollegeSystem.enums;

public enum Nationality {

    Nationality,Citizenship;

    @Override
    public String toString() {
        switch (this){
            case Citizenship -> {
                return "Citizenship";
            }

            case Nationality -> {
                return "Nationality";
            }

            default -> {
                return "unknown nationality";
            }
        }
    }
}
