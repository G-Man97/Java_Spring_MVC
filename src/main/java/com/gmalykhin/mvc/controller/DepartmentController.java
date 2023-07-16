package com.gmalykhin.mvc.controller;

import com.gmalykhin.mvc.dto.AverageSalaryByDepartmentDTO;
import com.gmalykhin.mvc.entity.Department;
import com.gmalykhin.mvc.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/departments")
public class DepartmentController {

    private final MyService myService;

    @Autowired
    public DepartmentController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping
    public String showAllDepartments(Model model){
        List<Department> listOfDepartments = myService.getAllDepartments();
        model.addAttribute("listOfDepartments", listOfDepartments);

        return "all-departments";
    }

    @RequestMapping("/add-new-department")
    public String addNewDepartment(Model model) {
        Department newDepartment = new Department();
        model.addAttribute("department", newDepartment);

        return "department-info";
    }

    @RequestMapping("/save-department")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        myService.saveDepartment(department);
        return "redirect:/api/departments";
    }

    @RequestMapping("/update-department")
    public String updateDepartment(@RequestParam("departmentId") int id, Model model){
        Department department = myService.getDepartment(id);
        model.addAttribute("department", department);

        return "department-info";
    }
    @RequestMapping("/delete-department")
    public String deleteDepartment(@RequestParam("departmentId") int id){
        myService.deleteDepartment(id);
        return "redirect:/api/departments";
    }

    @RequestMapping("/average-salary-by-department")
    public String queryView(Model model) {
        List<AverageSalaryByDepartmentDTO> listOfDepartments = myService.getAvgSalaryByDepartment();
        model.addAttribute("listOfDepartments", listOfDepartments);

        return "average-salary";
    }
}
