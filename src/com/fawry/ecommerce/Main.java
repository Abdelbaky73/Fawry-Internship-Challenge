package com.fawry.ecommerce;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Omar", 50);
        
        Shippable_expired_product cheese = new Shippable_expired_product("Cheese", 100, 5, LocalDate.of(2025, 12, 1), 0.2); 

        Shippable_expired_product biscuits = new Shippable_expired_product("Biscuits", 150,0 , LocalDate.of(2025, 12, 1), 0.7); 

        Product scratchCard = new Product("Scratch Card", 50, 10); 

        Cart cart = new Cart();
        cart.addProduct(cheese, 2);       
        cart.addProduct(biscuits, 1);     
        cart.addProduct(scratchCard, 1);  

        
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);
    }
}
