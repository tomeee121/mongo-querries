package TB.mongoquerries.repository;

import TB.mongoquerries.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{'name': ?0}")
    List<Employee> findByName(String name);

    @Query("{'name': ?0, 'department': ?1}")
    List<Employee> findByNameAndDepartment(String name, String department);
}
