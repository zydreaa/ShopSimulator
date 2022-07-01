package Shop;

import java.util.ArrayList;

public class Sales extends Product{

    public static ArrayList<Sales> sales = new ArrayList<>();

    public Sales(String productName, double price, int quantity) {
        super(productName, price, quantity);
    }


}

