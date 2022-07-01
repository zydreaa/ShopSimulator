package Shop;

import java.util.ArrayList;

public class Customer {

    public static ArrayList<Customer> customers = new ArrayList<>();
    private String customerName;
    double balance;
    double moneySpend;

    public Customer(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public Customer (String customerName, double balance, double moneySpend){
        this.customerName = customerName;
        this.balance = balance;
        this.moneySpend = moneySpend;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMoneySpend() {
        return moneySpend;
    }

    public void setMoneySpend(double moneySpend) {
        this.moneySpend = moneySpend;
    }

    @Override
    public String toString() {
        return " | " + customerName + " | " + balance + " | " + moneySpend + " | ";
    }


}

