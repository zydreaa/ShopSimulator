package Shop;

import java.util.ArrayList;

public class Customer {

    public static ArrayList<Customer> customers = new ArrayList<>();
    public int customerId;
    private String customerName;
    double balance;
    double moneySpend;

    public Customer(int customerId, String customerName, double balance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = getBalance();
    }

    public Customer (String customerName, double balance, double moneySpend){
        this.customerName = customerName;
        this.balance = balance;
        this.moneySpend = moneySpend;
    }

    public Customer(int customerId, String customerName, double balance, double moneySpend) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
        this.moneySpend = moneySpend;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
        return "Customer ID:" + customerId +
                " | customerName: " + customerName +
                "| Balance: " + balance +
                "\n";
    }
}

