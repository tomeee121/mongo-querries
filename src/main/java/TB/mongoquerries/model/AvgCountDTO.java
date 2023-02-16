package TB.mongoquerries.model;

import lombok.Data;
import lombok.ToString;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
@ToString
public class AvgCountDTO {
    @Id
    private String _id;
    private int count;
}
