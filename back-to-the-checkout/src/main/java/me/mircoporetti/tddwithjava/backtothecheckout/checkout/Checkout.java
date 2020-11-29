package me.mircoporetti.tddwithjava.backtothecheckout.checkout;

import me.mircoporetti.tddwithjava.backtothecheckout.exception.ProductNotInPriceListException;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private final PriceRuleBook priceRuleBook;
    private List<String> cart = new ArrayList<>();

    public Checkout(PriceRuleBook priceRuleBook) {
        this.priceRuleBook = priceRuleBook;
    }

    public void scan(String product) {
        if(priceRuleBook.getRules().containsKey(product)){
            cart.add(product);
        }else{
            throw new ProductNotInPriceListException("Product " + product + " doesn't exist in this supermarket!");
        }
    }

    public int total() {
        if(!cart.isEmpty()) {
            PricePolicy pricePolicy = priceRuleBook.getRules().get(cart.get(0));
            return pricePolicy.getUnitPrice();
        }else{
            return 0;
        }
    }
}
