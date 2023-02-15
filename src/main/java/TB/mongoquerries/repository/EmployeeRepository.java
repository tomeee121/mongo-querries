package TB.mongoquerries.repository;

import TB.mongoquerries.model.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employees, String> {
    @Query(value = "{'name': ?0}", fields = "{'id':0, 'firstname':0}")
    List<Employees> findByName(String name);

    @Query("{'name': ?0, 'department': ?1}")
    List<Employees> findByNameAndDepartment(String name, String department);
}
