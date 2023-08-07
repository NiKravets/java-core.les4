import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class Product {

    private String name;
    private double price;

    @Override
    public String toString(){
        return name + " " + price + "\n";
    }
}
