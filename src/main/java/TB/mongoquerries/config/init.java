package TB.mongoquerries.config;

import TB.mongoquerries.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class init {
    @Autowired
    MongoTemplate mongoTemplate;
    @EventListener(ApplicationContextEvent.class)
    void init() {
        ArrayList<Employees> objects = new ArrayList<>();
        Employees mat = new Employees("mat", "Mateusz", "Kowal", 24, "HR");
        Employees rob = new Employees("rob", "Robert", "Mak", 22, "IT");
        Employees tom = new Employees("tom", "Tomasz", "Lok", 26, "IT");
        Employees tom1 = new Employees("tom", "Tomasz", "Lok", 26, "IT");

        objects.add(mat);
        objects.add(rob);
        objects.add(tom);
        objects.add(tom1);
        mongoTemplate.insertAll(objects);
    }
}
