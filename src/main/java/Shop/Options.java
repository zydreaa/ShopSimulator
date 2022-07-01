package Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Options {

    private  boolean isValidated = false;
    private Customer customer;
    private Product product;
    private Sales sale;

    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Sales> sales = new ArrayList<>();

    void addCustomer() {
        System.out.println("Please enter your name: ");
        String customerName = scanner.next();

        System.out.println("Please enter the balance of your wallet: ");
        double balance = scanner.nextInt();

        double moneySpend = 0;

        Customer newCustomer = new Customer(customerName, balance, moneySpend);
        this.customers.add(newCustomer);
        System.out.println("Customer " + newCustomer.getCustomerName() + "  now is a member of Walmart!");
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

    public void addSales() {
        System.out.println("Please enter the name of product: ");
        String productName = scanner.next();

        System.out.println("Please enter the price of product: ");
        double price = scanner.nextDouble();

        System.out.println("Please enter the quantity of product: ");
        int quantity = scanner.nextInt();

        Sales newSale = new Sales(productName, price, quantity);
        this.sales.add(newSale);
        System.out.println("New product was added on shop sale list!");
    }
    public void allSales() {
        //Existing sale products in the shop
        Sales butter = new Sales("butter", 0.99, 5);
        this.sales.add(butter);
        Sales yogurt = new Sales("yogurt", 0.49, 5);
        this.sales.add(yogurt);
        Sales chocolate = new Sales("chocolate", 0.89, 10);
        this.sales.add(chocolate);

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

    public void allCustomers() {

        //Existing customers in the shop
        Customer zydre = new Customer("Zydre", 100, 0);
        this.customers.add(zydre);
        Customer benas = new Customer("Benas", 50, 0);
        this.customers.add(benas);
        Customer rima = new Customer("Rima", 150, 0);
        this.customers.add(rima);


        //Report table of all customers
        System.out.println("--------------------------------------------------");
        System.out.printf("              LIST OF ALL CUSTOMERS                ");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.printf("%15s %15s %15s", "Customer name", "Balance", "Money spend");
        System.out.println();
        System.out.println("--------------------------------------------------");
        for (Customer customer : customers) {
            System.out.format("%15s %15s %15s", customer.getCustomerName(), customer.getBalance(), customer.getMoneySpend());
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }

    public void allProducts() {
        //Existing products in the shop
        Product fish = new Product("fish", 14.99, 20);
        this.products.add(fish);
        Product meat = new Product("meat", 9.99, 15);
        this.products.add(meat);
        Product bread = new Product("bread", 2.49, 10);
        this.products.add(bread);
        Product avocado = new Product("avocado", 0.99, 15);
        this.products.add(avocado);
        Product eggs = new Product("eggs", 1.49, 10);
        this.products.add(eggs);

        //Existing sale products in the shop added to all product report
        allSales();

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
        for (Sales sales : sales) {
            System.out.format("%15s %15s %15s", sales.getProductName(), sales.getPrice(), sales.getQuantity());
            System.out.println();
        }
            System.out.println("--------------------------------------------------");
        }



//    public int checkBalance (String customerName, double totalPrice){
//        int temporary = 0;
//        for (Customer customer : customers) {
//            if (customer.customerName.equals(customerName)) {
//                if (balance >= totalPrice) {
//                    temporary = 1;
//                    break;
//                }
//            }
//        }
//        return temporary;
//    }
//    public String validateCustomer(String name){
//        try {
//            this.isValidated = this.
//            if (!this.isValidated) return "This Customer doesn't exist at this shop!";
//        }catch (Exception e) {
//            return "Error: " + e.getMessage();
//        }
//        return "Customer is accepted to the shop. Enjoy your time at Walmart!";
//    }
//
//    public void buyProduct() {
//            String customerName = "";
//            double totalPrice;
//
//
//
//            System.out.println("Please enter your name: ");
//            customerName = scanner.next();
//
//            int checkBalance = customers.checkBalance(customerName, totalPrice);
//
//            System.out.println("Please enter the name of product you wish to buy it: ");
//            Product productName = scanner.next();
//
//            System.out.println("Please enter the quantity you wish to buy: ");
//            int quantity = scanner.nextInt();
//
//
//        double totalPrice = productName.getPrice() * quantity;
//            double newBalance = customerName.balance - totalPrice;
//    }

}
