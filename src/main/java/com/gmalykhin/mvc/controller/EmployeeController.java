package com.gmalykhin.mvc.controller;

import com.gmalykhin.mvc.dto.EmployeeDTO;
import com.gmalykhin.mvc.entity.*;
import com.gmalykhin.mvc.service.MyService;
import com.gmalykhin.mvc.service.SomeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private final MyService myService;

    @Autowired
    public EmployeeController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping
    public String showAllEmployees(Model model) {
        List<Employee> listOfEmployees = myService.getAllEmployees();
        model.addAttribute("listOfEmployees", listOfEmployees);

        return "all-employees";
    }

    @RequestMapping("/add-new-employee")
    public String addNewEmployee(Model model) {
        Employee newEmployee = new Employee();
        List<Department> listOfDepartments = myService.getAllDepartments();

        model.addAttribute("listOfDepartments", listOfDepartments);
        model.addAttribute("employee", newEmployee);

        return "employee-info";
    }
    @RequestMapping(value = "/save-employee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("listOfEmployees", employee);
        myService.saveEmployee(employee);

        return "redirect:/api/employees";
    }

    @RequestMapping("/update-employee")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee = myService.getEmployee(id);
        List<Department> listOfDepartments = myService.getAllDepartments();

        model.addAttribute("listOfDepartments", listOfDepartments);
        model.addAttribute("employee", employee);
        return "employee-info";
    }
    @RequestMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        myService.deleteEmployee(id);
        return "redirect:/api/employees";
    }

    @RequestMapping("/by-department")
    public String employeesByDepartment(Model model) {
        List<EmployeeDTO> listOfEmployeeDTO = myService.getEmpByDepartment();
        model.addAttribute("listOfEmployeeDTO", listOfEmployeeDTO);

        return "employees-by-department";
    }

    @RequestMapping(value = "/search-employee", method = RequestMethod.POST)
    public String searchEmployee(SomeData someData, Model model) {
        List<EmployeeDTO> listOfEmployeeDTO = myService.searchEmployee(someData.getStrData());

        model.addAttribute("listOfEmployeeDTO", listOfEmployeeDTO);
        return "employees-by-department";
    }
}
