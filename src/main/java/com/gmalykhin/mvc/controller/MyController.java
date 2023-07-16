package com.gmalykhin.mvc.controller;

import com.gmalykhin.mvc.dto.AverageSalaryByDepartmentDTO;
import com.gmalykhin.mvc.dto.EmployeeDTO;
import com.gmalykhin.mvc.entity.*;
import com.gmalykhin.mvc.service.MyService;
import com.gmalykhin.mvc.service.SomeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = myService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/deps")
    public String showAllDepartments(Model model){

        List<Department> allDepartments = myService.getAllDepartments();
        model.addAttribute("allDeps", allDepartments);

        return "all-departments";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        List<Department> allDepartments = myService.getAllDepartments();

        model.addAttribute("deps", allDepartments);
        model.addAttribute("emps", employee);

        return "employee-info";
    }
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult
                               , Model model) {
        if(bindingResult.hasErrors()) {

            List<Department> allDepartments = myService.getAllDepartments();

            model.addAttribute("emps", employee);
            model.addAttribute("deps", allDepartments);

            return "employee-info";
        } else {
            myService.saveEmployee(employee);
            return "redirect:/";
        }
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = myService.getEmployee(id);
        List<Department> allDepartments = myService.getAllDepartments();

        model.addAttribute("deps", allDepartments);
        model.addAttribute("emps", employee);
        return "employee-info";
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
        myService.deleteEmployee(id);
        return "redirect:/";
    }

    @RequestMapping("/addNewDepartment")
    public String addNewDepartment(Model model) {
        Department department = new Department();

        model.addAttribute("deps", department);

        return "department-info";
    }

    @RequestMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        myService.saveDepartment(department);
        return "redirect:/deps";
    }

    @RequestMapping("/updateDepartment")
    public String updateDepartment(@RequestParam("depId") int id, Model model){
        Department department = myService.getDepartment(id);
        model.addAttribute("deps", department);

        return "department-info";
    }
    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam("depId") int id){
        myService.deleteDepartment(id);
        return "redirect:/deps";
    }

    @RequestMapping("/avgSalary")
    public String queryView(Model model) {
        List<AverageSalaryByDepartmentDTO> list = myService.getAvgSalaryByDepartment();
        model.addAttribute("list", list);

        return "avg-salary";
    }

    @RequestMapping("/empByDepartment")
    public String empByDepartment(Model model) {
        List<EmployeeDTO> list = myService.getEmpByDepartment();
        model.addAttribute("list", list);

        return "emp-by-department";
    }

    @RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
    public String searchEmployee(SomeData someData, Model model) {
        List<EmployeeDTO> searchedEmployees = myService.searchEmployee(someData.getStrData());

        model.addAttribute("list", searchedEmployees);
        return "emp-by-department";
    }
}
