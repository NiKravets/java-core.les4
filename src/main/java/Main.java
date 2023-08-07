import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CustomerException {
        Customer[] customers = {
                new Customer("Иван Петров", 40, "123456789"),
                new Customer("Петр Иванов", 30, "987654321")
        };

        Product[] products = {
                new Product("Товар 1", 100),
                new Product("Товар 2", 250),
                new Product("Товар 3", 300),
                new Product("Товар 4", 450),
                new Product("Товар 5", 600)
        };

        Order[] orders = new Order[5];

            try {
                orders[0] = makePurchase(customers, products, "Иван Петров", "Товар 1", "20");
                orders[1] = makePurchase(customers, products, "Петр Иванов", "Товар 3", "5");
                orders[2] = makePurchase(customers, products, "Петр Иванов", "Товар 6", "18");
                orders[3] = makePurchase(customers, products, "Петр Иванов", "Товар 5", "105");
                orders[4] = makePurchase(customers, products, "Иван Петров", "Товар 4", "20");
            } catch (CustomerException ce) {
                throw new CustomerException(ce.getMessage());
            } catch (ProductException pe) {
                System.out.println("Ошибка: " + pe.getMessage());
            } catch (AmountException ae) {
                System.out.println("Ошибка: " + ae.getMessage());

            }



        int numOfPurchases = 0;

        for (Order order : orders) {
            if (order != null) {
                System.out.println(order);
                numOfPurchases++;
            }
        }
        System.out.println("Итого совершено покупок: " + numOfPurchases);
    }




    public static Order makePurchase(Customer[] customers, Product[] products,
                                     String customerName, String productName,
                                     String quantity) throws CustomerException, ProductException, AmountException {

        Order order;

        Customer chosenCustomer = null;
        for (Customer customer : customers) {
            if (customer.getFullName().equals(customerName)) {
                chosenCustomer = customer;
                break;
            }
        }
        if (chosenCustomer == null) {
            throw new CustomerException("Неверный покупатель!");
        }

        Product chosenProduct = null;
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                chosenProduct = product;
                break;
            }
        }



        if (Integer.parseInt(quantity) < 0 || Integer.parseInt(quantity) > 100) {
            quantity = "1";
            throw new AmountException("Неверное количество!");

        }
        order = new Order(chosenCustomer, chosenProduct, quantity);

        if (chosenProduct == null) {
            order = null;
            throw new ProductException("Неверный товар!");
        }
        return order;

    }
}
