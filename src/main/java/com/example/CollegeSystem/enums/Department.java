package com.example.CollegeSystem.enums;

public enum Department {
    ComputerScience, ElectricalEngineering, MechanicalEngineering, Biology,Psychology,BusinessAdministration,History,English,
    Chemistry,CivilEngineering;

    @Override
    public String toString() {
        switch (this){
            case Biology -> {
                return "Biology";
            }

            case English -> {
                return "English";
            }

            case History -> {
                return "History";
            }

            case Chemistry -> {
                return "Chemistry";
            }

            case Psychology -> {
                return "Psychology";
            }

            case ComputerScience -> {
                return "Computer Science";
            }

            case CivilEngineering -> {
                return "Civil Engineering";
            }

            case ElectricalEngineering -> {
                return "Electrical Engineering";
            }

            case MechanicalEngineering -> {
                return "Mechanical Engineering";
            }

            case BusinessAdministration -> {
                return "Business Administration";
            }
            default -> {
                return "unknown faculty";
            }
        }
    }
}
