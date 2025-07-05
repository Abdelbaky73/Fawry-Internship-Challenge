package com.fawry.ecommerce;

import java.time.LocalDate;

public class Shippable_expired_product extends Expired_Product implements Shippable {
    private double weight;

    public Shippable_expired_product(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

