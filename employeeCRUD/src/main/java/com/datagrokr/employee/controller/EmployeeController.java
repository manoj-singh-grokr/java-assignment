package com.datagrokr.employee.controller;

import com.datagrokr.employee.entity.Employee;
import com.datagrokr.employee.entity.Sales;
import com.datagrokr.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.findAll());
        return "index";
    }

    @PostMapping("/addEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeForm";
    }

    @GetMapping("/employee/{id}")
    public @ResponseBody Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    @GetMapping("/delete/{emp_id}")
    public String deleteEmployee(@PathVariable("emp_id") Integer emp_id){
        Employee employee = employeeService.findById(emp_id);
        if(employee == null) {
            throw new RuntimeException("Employee doesn't exist");
        }
        employeeService.deleteById(emp_id);
        return "redirect:/";
    }

    @GetMapping("/employeeUpdateForm/{id}")
    public String employeeUpdateForm(@PathVariable(value="id") Integer id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/mostBoughtBook")
    public @ResponseBody List<Sales> mostBought(){
        return employeeService.findMostBoughtBook();
    }
}
