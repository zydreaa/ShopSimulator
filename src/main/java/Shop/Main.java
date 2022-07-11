package Shop;

import javax.swing.*;

public class Main {


    public static void main(String[] args) throws Exception {

        Options options = new Options();

        JOptionPane.showMessageDialog(null, "Welcome to Walmart!");
        String menu = "";

        while (!menu.equals("0")) {

            menu = JOptionPane.showInputDialog(
                    "Please enter your choice:\n" +
                    "1. Add new customer\n" +
                    "2. Add new product\n" +
                    "3. Buy product\n" +
                    "4. Add sales product\n" +
                    "5. Show sales in the shop\n" +
                    "6. Show all products in the shop\n" +
                    "7. Show report of the shop customers and balances\n" +
                    "0. QUIT"
                    );

            switch (menu) {
                case "1":
                    options.addCustomer();
                    break;
                case "2":
                    options.addProduct();
                    break;
                case "3":
                    options.buyProduct();
                    break;
                case "4":
                    options.addSales();
                    break;
                case "5":
                    options.viewSales();
                    break;
                case "6":
                    options.viewAllProducts();
                    break;
                case "7":
                    options.viewAllCustomers();
                    break;
                case "0":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Please enter one of the valid options or QUIT!");
            }
        }
    }
}

