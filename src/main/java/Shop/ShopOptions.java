//package Shop;
//
//import java.util.Scanner;
//
//public class ShopOptions {
//
//    static Options options =new Options();
//
//    public static void options() {
//
//        System.out.println("Please choose an option below: ");
//        System.out.println(" 1. Add new customer");
//        System.out.println(" 2. Add new product");
//        System.out.println(" 3. Buy product");
//        System.out.println(" 4. Add sale product");
//        System.out.println(" 5. Show sales in the shop");
//        System.out.println(" 6. Show all products in the shop");
//        System.out.println(" 7. Report of the shop customers");
//        System.out.println(" 0. QUIT");
//
//        Scanner scanner = new Scanner(System.in);
//        String option = scanner.nextLine();
//
//        do {
//            switch (option) {
//                case "1":
//                    options.addCustomer();
//                    break;
//                case "2":
//                    options.addProduct();
//                    break;
////            case 3:
////                options.buyProduct();
////                break;
//                case "4":
//                    options.addSales();
//                    break;
//                case "5":
//                    options.allSales();
//                    break;
//                case "6":
//                    options.allProducts();
//                    break;
//                case "7":
//                    options.allCustomers();
//                    break;
//                case "0":
//                    System.exit(0);
//                    break;
//            }
//        }while (option != "0");
//    }
//}
//
