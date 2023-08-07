import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Order {

    private Customer customer;
    private Product product;
    private String quantity;

    @Override
     public String toString(){
        return "Заказ: " + quantity + "шт. " + product + " для " + customer;
    }
}
