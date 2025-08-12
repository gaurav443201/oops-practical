import java.util.ArrayList;
import java.util.Scanner;

// Product class
class Product {
    private String name;
    private int quantity;
    private double price;

    // Constructor with all parameters
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Overloaded constructor with default quantity
    public Product(String name, double price) {
        this(name, 1, price);
    }

    // Overloaded constructor with default quantity and price
    public Product(String name) {
        this(name, 10, 0.0);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to calculate total price for this product
    public double getTotalPrice() {
        return quantity * price;
    }
}

// Main class
public class ECommerceProcessing {

    // Method to apply discount based on total amount
    public static double applyDiscount(double total) {
        if (total > 10000) {
            return total * 0.10;
        } else if (total > 5000) {
            return total * 0.05;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> cart = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        // Input product details
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1) + ":");
            System.out.print("Enter product name: ");
            String name = sc.next();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            Product p = new Product(name, quantity, price);
            cart.add(p);
        }

        // Calculate totals
        double grandTotal = 0.0;
        for (Product p : cart) {
            grandTotal += p.getTotalPrice();
        }

        double discount = applyDiscount(grandTotal);
        double netTotal = grandTotal - discount;

        // Print invoice
        System.out.println("\n--- Invoice ---");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Product", "Qty", "Price", "Total");

        for (Product p : cart) {
            System.out.printf("%-15s %-10d %-10.2f %-10.2f\n",
                p.getName(), p.getQuantity(), p.getPrice(), p.getTotalPrice());
        }

        System.out.println("----------------------------------------");
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        System.out.printf("Discount: %.2f\n", discount);
        System.out.printf("Net Total: %.2f\n", netTotal);
    }
}
