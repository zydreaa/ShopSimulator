package Shop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Options {

    private JFrame frame;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Sales> sales = new ArrayList<>();

    public Options() {
        frame = new JFrame();
    }

    public void existingCustomers(){
        Customer zydre = new Customer(customers.size(), "Zydre", 50, 0);
        customers.add(zydre);
        Customer benas = new Customer(customers.size(),"Benas", 25, 0);
        customers.add(benas);
        Customer rima = new Customer(customers.size(),"Rima", 15, 0);
        customers.add(rima);
    }

    void addCustomer() {
        existingCustomers();

        int customerId = customers.size();
        System.out.println("Please enter your name: ");
        String customerName = scanner.next();

        System.out.println("Please enter the balance of your wallet: ");
        double balance = scanner.nextInt();

        double moneySpend = 0;

        Customer newCustomer = new Customer(customerId, customerName, balance, moneySpend);
        this.customers.add(newCustomer);
        System.out.println("Customer " + newCustomer.getCustomerName() + "  now is a member of Walmart!");
    }

    public ArrayList<Customer> getAllCustomers(){
        return this.customers;
    }

    void addProduct() {
        System.out.println("Please enter the name of product: ");
        String productName = scanner.next();

        System.out.println("Please enter the price of product: ");
        double price = scanner.nextDouble();

        System.out.println("Please enter the quantity of product delivered to shop: ");
        int quantity = scanner.nextInt();

        Product newProduct = new Product(productName, price, quantity);
        this.products.add(newProduct);
        System.out.println("New product was added to shop!");
    }

    public ArrayList<Product> getAllProducts(){
        return this.products;
    }

    public void addSales() {

        System.out.println("Please enter the name of product: ");
        String productName = scanner.next();

        System.out.println("Please enter the price of product: ");
        double price = scanner.nextDouble();

        System.out.println("Please enter the quantity of product: ");
        int quantity = scanner.nextInt();

        Sales newSale = new Sales(productName, price, quantity);
        this.sales.add(newSale);
        this.products.add(newSale); //adds to main product list as well
        System.out.println("New product was added on shop sale list!");
    }

    public void viewSales() {

        //Report table of all sale products in the shop
        System.out.println("--------------------------------------------------");
        System.out.printf("              SALES IN THE SHOP                  ");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.printf("%15s %15s %15s", "Product name", "Price", "Quantity");
        System.out.println();
        System.out.println("--------------------------------------------------");
        for (Sales sales : sales) {
            System.out.format("%15s %15s %15s", sales.getProductName(), sales.getPrice(), sales.getQuantity());
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }

    public void viewAllCustomers() {
    //Existing customers in the shop
        existingCustomers();

        //Report table of all customers
        System.out.println("--------------------------------------------------");
        System.out.printf("              LIST OF ALL CUSTOMERS                ");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.printf("%5s %15s %10s %15s", "ID", "Customer name", "Balance", "Money spend");
        System.out.println();
        System.out.println("--------------------------------------------------");
        for (Customer customer : customers) {
            System.out.format("%5s %10s %15s %15s", customer.getCustomerId(), customer.getCustomerName(), customer.getBalance(), customer.getMoneySpend());
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }

    public void existingProducts() {
        Product fish = new Product("Fish", 14.99, 20);
        products.add(fish);
        Product meat = new Product("Meat", 9.99, 15);
        products.add(meat);
        Product bread = new Product("Bread", 2.49, 10);
        products.add(bread);
        Product avocado = new Product("Avocado", 0.99, 15);
        products.add(avocado);
        Product eggs = new Product("Eggs", 1.49, 10);
        products.add(eggs);
    }

    public void viewAllProducts() {
        //Existing products in the shop
        existingProducts();

        //Report table of all products in the shop
        System.out.println("--------------------------------------------------");
        System.out.printf("              IN THE SHOP WE HAVE                  ");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.printf("%15s %15s %15s", "Product name", "Price", "Quantity");
        System.out.println();
        System.out.println("--------------------------------------------------");
        for (Product product : products) {
            System.out.format("%15s %15s %15s", product.getProductName(), product.getPrice(), product.getQuantity());
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }

    public void buyProduct() {
        try{
            existingCustomers();
            ArrayList<Customer> allCustomers = getAllCustomers();
            Customer selectedCustomer = (Customer) JOptionPane.showInputDialog(
                this.frame,
                "Select your name",
                "Customer name",
                JOptionPane.QUESTION_MESSAGE,
                null,
                allCustomers.toArray(),
                allCustomers.toArray()[0]
        );

        existingProducts();

        ArrayList<Product> allProducts = getAllProducts();
        Product selectedProduct = (Product) JOptionPane.showInputDialog(
                this.frame,
                "Select product to buy",
                "Buy product",
                JOptionPane.QUESTION_MESSAGE,
                null,
                allProducts.toArray(),
                allProducts.toArray()[0]
        );

        Integer quantity = Integer.valueOf(JOptionPane.showInputDialog("How many do you want to buy?"));
        double totalPrice = selectedProduct.getPrice() * quantity;
        if (selectedProduct.getQuantity() < quantity) throw new Exception("Sorry, product not available in the shop at the moment!");

        if (selectedCustomer.getBalance() < totalPrice) throw new Exception("Not enough balance");

        selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
        selectedCustomer.setBalance(selectedCustomer.getBalance() - totalPrice);
        selectedCustomer.setMoneySpend(selectedCustomer.getMoneySpend() + totalPrice);

        updateProductQuantity(selectedProduct);
        updateCustomerBalance(selectedCustomer);

        JOptionPane.showMessageDialog(frame,"Product Purchased Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
    }

    public void updateCustomerBalance(Customer selectedCustomer) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == selectedCustomer.getCustomerId()) {
               selectedCustomer.setBalance(customer.getBalance());
               selectedCustomer.setMoneySpend(customer.getMoneySpend());
               break;
            }
        }
    }

    public void updateProductQuantity(Product selectedProduct){
        for (Product product: products){
            if (product.getProductName() == selectedProduct.getProductName()){
                product.setQuantity(product.getQuantity());
                break;
            }
        }
    }

}
