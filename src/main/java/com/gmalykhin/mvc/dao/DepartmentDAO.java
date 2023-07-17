package com.gmalykhin.mvc.dao;

import com.gmalykhin.mvc.dto.AverageSalaryByDepartmentDTO;
import com.gmalykhin.mvc.dto.EmployeeDTO;
import com.gmalykhin.mvc.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> getAllDepartments();

    Department getDepartment(int id);

    void deleteDepartment(int id);

    void saveDepartment(Department department);

    List<AverageSalaryByDepartmentDTO> getAvgSalaryByDepartment();

    Department getDepartmentByDepartmentName(String departmentName);
}
