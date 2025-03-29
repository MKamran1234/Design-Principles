import java.util.*;

// Strategy Interface
interface TaxStrategy {
    double getTaxRate(String location, String product);
}

// Concrete Tax Strategies
class USTaxStrategy implements TaxStrategy {
    @Override
    public double getTaxRate(String state, String product) {
        return 0.07; // Example: 7% tax
    }
}

class EUTaxStrategy implements TaxStrategy {
    @Override
    public double getTaxRate(String country, String product) {
        return 0.2; // Example: 20% tax
    }
}

class ChineseTaxStrategy implements TaxStrategy {
    @Override
    public double getTaxRate(String product, String region) {
        return 0.1; // Example: 10% tax
    }
}

// Context Class
class TaxCalculator {
    private TaxStrategy taxStrategy;

    public TaxCalculator(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double calculateTax(String location, String product) {
        return taxStrategy.getTaxRate(location, product);
    }
}

class Order {
    private TaxCalculator taxCalculator;
    private List<Item> lineItems;
    private String location;

    public Order(TaxCalculator taxCalculator, String location) {
        this.taxCalculator = taxCalculator;
        this.lineItems = new ArrayList<>();
        this.location = location;
    }

    public void addItem(double price, int quantity, String product) {
        lineItems.add(new Item(price, quantity, product));
    }

    public double getOrderTotal() {
        double total = 0;
        for (Item item : lineItems) {
            double subtotal = item.getPrice() * item.getQuantity();
            total += subtotal * (1 + taxCalculator.calculateTax(location, item.getProduct()));
        }
        return total;
    }
}

class Item {
    private double price;
    private int quantity;
    private String product;

    public Item(double price, int quantity, String product) {
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        TaxCalculator usTaxCalculator = new TaxCalculator(new USTaxStrategy());
        Order order = new Order(usTaxCalculator, "CA");
        order.addItem(100, 2, "electronics");
        order.addItem(50, 1, "clothing");
        System.out.println("Order Total: " + order.getOrderTotal());
    }
}