package TB.mongoquerries.controller;

import TB.mongoquerries.model.Employees;
import TB.mongoquerries.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/employees/{name}")
    List<Employees> findByName(@PathVariable(value = "name") String name) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(name));
//        return mongoTemplate.find(query, Employee.class);
        return employeeRepository.findByName(name);
    }
    @GetMapping("/employees/{name}/{department}")
    List<Employees> findByName(@PathVariable(value = "name") String name, @PathVariable(value = "department") String department) {
        return employeeRepository.findByNameAndDepartment(name, department);
    }

    @PostMapping("/employees")
    List<Employees> saveAll(@RequestBody List<Employees> employees) {
        return employeeRepository.saveAll(employees);
    }

    @GetMapping("/employees")
    List<Employees> findAll() {
        return employeeRepository.findAll();
    }


}
