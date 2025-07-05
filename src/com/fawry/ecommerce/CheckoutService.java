package com.fawry.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        double shippingFees = 0;

        List<Shippable> itemsToShip = new ArrayList<>();
        List<CartItem> itemList = cart.getItems();

       
        for (int i = 0; i < itemList.size(); i++) {
            CartItem currentItem = itemList.get(i);
            Product product = currentItem.getProduct();
            int quantity = currentItem.getQuantity();

            if (quantity > product.getQuantity()) {
                throw new IllegalStateException(product.getName() + " is out of stock.");
            }

            if (product instanceof Expired_Product) {
                Expired_Product expired = (Expired_Product) product;
                if (expired.isExpired()) {
                    throw new IllegalStateException(product.getName() + " is expired.");
                }
            }

            subtotal += product.getPrice() * quantity;

            if (product instanceof Shippable) {
                Shippable s = (Shippable) product;
                for (int j = 0; j < quantity; j++) {
                    itemsToShip.add(s);
                    shippingFees += s.getWeight() * 10;
                }
            }
        }

        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalStateException("You don't have enough money");
        }

        
        for (int i = 0; i < itemList.size(); i++) {
            CartItem item = itemList.get(i);
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        
        customer.deduct(totalAmount);

        
        if (!itemsToShip.isEmpty()) {
            System.out.println("** Shipment notice **");
            double totalWeight = 0;

            for (int i = 0; i < itemList.size(); i++) {
                Product product = itemList.get(i).getProduct();
                int quantity = itemList.get(i).getQuantity();

                if (product instanceof Shippable) {
                    Shippable s = (Shippable) product;
                    int grams = (int) (s.getWeight() * 1000 * quantity);
                    System.out.println(quantity + "x " + s.getName() + " " + grams + "g");
                    totalWeight += s.getWeight() * quantity;
                }
            }

            System.out.printf("Total package weight %.1fkg\n", totalWeight);
        }

        
        System.out.println("** Checkout receipt **");
        for (int i = 0; i < itemList.size(); i++) {
            Product product = itemList.get(i).getProduct();
            int quantity = itemList.get(i).getQuantity();
            int totalPrice = (int)(product.getPrice() * quantity);
            System.out.println(quantity + "x " + product.getName() + " " + totalPrice);
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + (int) subtotal);
        System.out.println("Shipping " + (int) shippingFees);
        System.out.println("Amount " + (int) totalAmount);
    }
}
