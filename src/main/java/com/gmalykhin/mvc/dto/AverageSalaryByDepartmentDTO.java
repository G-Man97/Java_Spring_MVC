package com.gmalykhin.mvc.dto;

public class AverageSalaryByDepartmentDTO {

    private final String departmentName;
    private final double averageSalary;

    public AverageSalaryByDepartmentDTO (String departmentName, double averageSalary) {
        this.departmentName = departmentName;
        this.averageSalary = averageSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getAverageSalary() {
        return averageSalary;
    }
}
