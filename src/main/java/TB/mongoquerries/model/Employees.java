package TB.mongoquerries.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employees {
    @Id
    private String id;
    private String name;
    private String firstname;
    private String lastName;
    private int age;
    private String department;

    public Employees(String name, String firstname, String lastName, int age, String department) {
        this.name = name;
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
    }
}
