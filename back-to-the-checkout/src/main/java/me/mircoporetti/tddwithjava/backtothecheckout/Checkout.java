package me.mircoporetti.tddwithjava.backtothecheckout;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private final PriceRuleBook priceRuleBook;
    private List<String> cart = new ArrayList<>();

    public Checkout(PriceRuleBook priceRuleBook) {
        this.priceRuleBook = priceRuleBook;
    }

    public void scan(String product) {
        cart.add(product);
    }

    public int total() {
        PricePolicy pricePolicy = priceRuleBook.getRules().get(cart.get(0));
        return pricePolicy.getUnitPrice();
    }
}
