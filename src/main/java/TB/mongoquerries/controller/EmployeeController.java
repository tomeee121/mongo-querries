package TB.mongoquerries.controller;

import TB.mongoquerries.model.Employee;
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

    @PostMapping("/employees")
    List<Employee> saveAll(@RequestBody List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @GetMapping("/employees")
    List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{name}")
    List<Employee> findByName(@PathVariable(value = "name") String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Employee.class);
    }


}
