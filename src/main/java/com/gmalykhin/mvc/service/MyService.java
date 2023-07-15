package com.gmalykhin.mvc.service;

import com.gmalykhin.mvc.entity.Department;
import com.gmalykhin.mvc.entity.Employee;

import java.util.List;

public interface MyService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    List<Department> getAllDepartments();

    Employee getEmployee(int id);
    void deleteEmployee(int id);

    Department getDepartment(int id);

    void deleteDepartment(int id);

    void saveDepartment(Department department);

    List<Object[]> getAvgSalaryByDepartment();

    List<Object[]> getEmpByDepartment();

    List<Object[]> searchEmployee(List<String> strData);
}
