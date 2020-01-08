package com.rafaelrahn.demospringrrr.personnel;

public enum PersonnelType {
    CUSTOMER("Customer"), EMPLOYER("Employer");

    private String description;

    PersonnelType(String description) {
        this.description = description;
    }

    String getDescription() {
        return this.description;
    }
}
