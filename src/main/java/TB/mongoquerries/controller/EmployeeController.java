package TB.mongoquerries.controller;

import TB.mongoquerries.model.Employee;
import TB.mongoquerries.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    List<Employee> saveAll(@RequestBody List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @GetMapping("/employees")
    List<Employee> findAll() {
        return employeeRepository.findAll();
    }


}
