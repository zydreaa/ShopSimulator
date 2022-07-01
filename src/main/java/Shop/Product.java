package Shop;

import java.util.ArrayList;

public class Product {
    public static ArrayList<Product> products = new ArrayList<>();
    private String productName;
    double price;
    int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product) {
        this.productName = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void Quantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " | " + productName + " | " + price + " | " + quantity + " | ";
    }


}

