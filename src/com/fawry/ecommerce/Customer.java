package com.fawry.ecommerce;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deduct(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("You don't have enough money");
        }
        balance -= amount;
    }

    public String getName() {
        return name;
    }
}

