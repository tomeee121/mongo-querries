package TB.mongoquerries.controller;

import TB.mongoquerries.model.AvgCountDTO;
import TB.mongoquerries.model.Employees;
import TB.mongoquerries.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/employees/age/{age}")
    List<AvgCountDTO> findByAgeMatch(@PathVariable(value = "age") int age) {
        MatchOperation matchOperation = Aggregation.match(new Criteria("age").is(age));
        GroupOperation groupOperation = Aggregation.group("age").count().as("count");
        SortOperation sortOperation = Aggregation.sort(Sort.by(Sort.Direction.DESC, "count"));
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, groupOperation, sortOperation);
        AggregationResults<AvgCountDTO> aggregationResults = mongoTemplate.aggregate(aggregation, "employees", AvgCountDTO.class);
        System.out.println(aggregationResults.getMappedResults());
        return aggregationResults.getMappedResults();
    }

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
