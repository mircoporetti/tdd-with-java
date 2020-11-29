package me.mircoporetti.tddwithjava.backtothecheckout.checkout;

import me.mircoporetti.tddwithjava.backtothecheckout.exception.ProductNotInPriceListException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
            AtomicInteger total = new AtomicInteger();
            cart.forEach(p -> {
                PricePolicy pricePolicy = getPricePolicyFor(p);
                total.addAndGet(pricePolicy.getUnitPrice());
            });
            return total.get();
        }else{
            return 0;
        }
    }

    private PricePolicy getPricePolicyFor(String product) {
        return priceRuleBook.getRules().get(product);
    }
}
