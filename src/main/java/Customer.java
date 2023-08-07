import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Customer {

    private String fullName;
    private int age;
    private String phoneNumber;

    @Override
    public String toString() {
        return fullName + "\n";
    }

}
