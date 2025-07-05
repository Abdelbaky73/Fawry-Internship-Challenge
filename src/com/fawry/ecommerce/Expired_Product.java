package com.fawry.ecommerce;

import java.time.LocalDate;

public class Expired_Product extends Product{
	protected LocalDate expiryDate;

	public Expired_Product(String name, double price, int quantity,LocalDate expiryDate) {
		super(name, price, quantity);
		this.expiryDate = expiryDate;
	}
	
	@Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
	
}
