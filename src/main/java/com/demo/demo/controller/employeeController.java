package com.demo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.model.Employee;
import com.demo.demo.service.employeeService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.servlet.http.HttpServlet;
@Controller
public class employeeController {
    @Autowired
    private employeeService employeeService;
    public employeeController() {
    }
//    @PostMapping("/save")
//     public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
//         employeeService.addEmployee(employee);
//         return new ResponseEntity<Employee>(employee , HttpStatus.OK);
//     }
//     @GetMapping("/getAll")
//     public ResponseEntity<List<Employee>> getAllEmployees() {
//         return ResponseEntity.ok(employeeService.getAllEmployees());
//     }
//     @GetMapping("/getEmployees/{id}")
//     public ResponseEntity<Optional<Employee>>getEmployee(@PathVariable Long id) {
//         return ResponseEntity.ok(employeeService.getEmployee(id));
//     }
//     @PutMapping("/updateEmployees/{id}")
//     public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee , @PathVariable Long id) {
//         employeeService.updateEmployee(employee);
//         return new ResponseEntity<Employee>(employee , HttpStatus.OK);
//     }
//     @DeleteMapping("/deleteEmployees/{id}")
//     public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
//         employeeService.deleteEmployee(id);
//         return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
//     }
@GetMapping("/list")
public String listEmployees(Model model) {
    model.addAttribute("employees", employeeService.getAllEmployees());
    return "employee";
}
@GetMapping("/add")
public String addEmployee(Model model) {
    model.addAttribute("employee", new Employee());
    return "create_employee";
}
@PostMapping("/save")
public String addEmployee(Employee employee) {
    employeeService.addEmployee(employee);
    return "redirect:/list";
}
@GetMapping("/edit/{id}")
public String editEmployee(@PathVariable Long id, Model model) {
    model.addAttribute("employee", employeeService.getEmployee(id));
    return "editEmployee";
}
@PostMapping("/edit/{id}")
public String editEmployee(Employee employee) {
    employeeService.updateEmployee(employee);
    return "redirect:/list";
}
@GetMapping("/delete/{id}")
public String deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return "redirect:/list";
}
}

