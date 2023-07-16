package com.gmalykhin.mvc.dao;

import com.gmalykhin.mvc.dto.EmployeeDTO;
import com.gmalykhin.mvc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<EmployeeDTO> getEmpByDepartment();

    List<EmployeeDTO> searchEmployee(List<String> strData);
}
