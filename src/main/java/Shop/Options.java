package Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Options {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Sales> sales = new ArrayList<>();

    void addCustomer() {
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
        Customer zydre = new Customer(customers.size(), "zydre", 100, 0);
        this.customers.add(zydre);
        Customer benas = new Customer(customers.size(),"Benas", 50, 0);
        this.customers.add(benas);
        Customer rima = new Customer(customers.size(),"Rima", 150, 0);
        this.customers.add(rima);


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

    public void buyProduct() {

        System.out.println("Please enter your customer ID: ");
        int customerId = scanner.nextInt();
        String selectedCustomerName = customers. get(customerId).getCustomerName();
        double selectedCustomerBalance = customers. get(customerId).getBalance();
        Customer selectedCustomer =new Customer(customerId, selectedCustomerName, selectedCustomerBalance);
        System.out.println(selectedCustomer);

        System.out.println("Please enter the name of product you wish to buy it: ");
        String productName = scanner.nextLine();
        System.out.println("Please enter the quantity you wish to buy: ");
        int quantityToBuy = scanner.nextInt();
        double selectedProductPrice = products.get(Integer.parseInt(productName)).getPrice();
        Product selectedProduct = new Product(productName, selectedProductPrice, quantityToBuy);

        double totalPrice = selectedProduct.getPrice() * quantityToBuy;
        System.out.println(totalPrice);

        int availableInShop = availableQuantity(productName, quantityToBuy);
        if (availableInShop == 0) {
        System.out.println("Sorry, product not available in the shop at the moment!");
        }
        int balanceChecker = checkBalance(customerId, totalPrice);
        if (balanceChecker == 1) {
        reduceCustomerBalance(selectedCustomer.getCustomerId(), totalPrice);
        reduceProductQuantity(selectedProduct.getProductName(), quantityToBuy);
        System.out.println("Your purchase was successful!");
        }
        if (balanceChecker == 0) {
        System.out.println("You don't have enough money at your wallet!");
        }
    }


    public int checkBalance(int customerId, double totalPrice){
        int check = 0;
        for (Customer customer: customers) {
            if (customer.getCustomerId() == customerId) {
                if (customer.getBalance() >= totalPrice) {
                    check = 1;
                    break;
                }
            }
        }
        return check;
    }

    public void reduceCustomerBalance(int customerId, double totalPrice) {
            for (Customer customer : customers) {
                if (customer.getCustomerId() == customerId) {
                    double newBalance= customer.balance - totalPrice;
                    customer.setBalance(newBalance);
                    customer.setMoneySpend(totalPrice);
                    break;
                }
            }
        }

        public int availableQuantity(String productName, int quantityToBuy){
        int availableInShop = 0;
            Product selectedProduct = products.get(Integer.parseInt(productName));
            if (selectedProduct.getQuantity() >= quantityToBuy){
                availableInShop = 1;
            }
            return availableInShop;
            }

    public void reduceProductQuantity (String productName, int quantityToBuy){
        for (Product product: products){
            if (product.getProductName() == productName){
                int newQuantity = product.getQuantity() - quantityToBuy;
                product.setQuantity(newQuantity);
                break;
            }
        }
    }

}
