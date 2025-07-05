package com.fawry.ecommerce;

public class Product {
	private String name;
	private double price;
	private int quantity;
	
	public Product(String name,double price,int quantity ){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public boolean isExpired(){
		return false;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}

	public void reduceQuantity(int amount) {
	    if (amount > quantity) {
	        throw new IllegalArgumentException("There is no enough stock.");
	    }
	    quantity -= amount;
	}

	
}
