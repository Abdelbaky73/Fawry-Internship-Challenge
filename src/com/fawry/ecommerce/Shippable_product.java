package com.fawry.ecommerce;

public class Shippable_product extends Product implements Shippable {
    private double weight;

    public Shippable_product(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
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

