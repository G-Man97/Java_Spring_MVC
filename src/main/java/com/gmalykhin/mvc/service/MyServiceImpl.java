package com.gmalykhin.mvc.service;

import com.gmalykhin.mvc.dao.DepartmentDAO;
import com.gmalykhin.mvc.dao.EmployeeDAO;
import com.gmalykhin.mvc.dto.AverageSalaryByDepartmentDTO;
import com.gmalykhin.mvc.dto.EmployeeDTO;
import com.gmalykhin.mvc.entity.Department;
import com.gmalykhin.mvc.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {

    private final EmployeeDAO employeeDAO;
    private final DepartmentDAO departmentDAO;

    @Autowired
    public MyServiceImpl(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO) {
        this.employeeDAO = employeeDAO;
        this.departmentDAO = departmentDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    @Transactional
    public Department getDepartment(int id) {
        return departmentDAO.getDepartment(id);
    }

    @Override
    @Transactional
    public void deleteDepartment(int id) {
        departmentDAO.deleteDepartment(id);
    }

    @Override
    @Transactional
    public void saveDepartment(Department department) {
        departmentDAO.saveDepartment(department);
    }

    @Override
    @Transactional
    public List<AverageSalaryByDepartmentDTO> getAvgSalaryByDepartment() {
        return departmentDAO.getAvgSalaryByDepartment();
    }

    @Override
    @Transactional
    public List<EmployeeDTO> getEmpByDepartment() {
        return employeeDAO.getEmpByDepartment();
    }

    @Override
    @Transactional
    public List<EmployeeDTO> searchEmployee(List<String> strData) {
        return employeeDAO.searchEmployee(strData);
    }
}
