package me.mircoporetti.tddwithjava.backtothecheckout.checkout;

import me.mircoporetti.tddwithjava.backtothecheckout.exception.ProductNotInPriceListException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Checkout {

    private final PriceRuleBook priceRuleBook;
    private List<CartItem> cart = new ArrayList<>();

    public Checkout(PriceRuleBook priceRuleBook) {
        this.priceRuleBook = priceRuleBook;
    }

    public void scan(String product) {
        if(priceRuleBook.getRules().containsKey(product)){
            Optional<CartItem> existingItem = cart.stream().filter(item -> item.name.equals(product)).findFirst();
            if(existingItem.isPresent()){
                existingItem.get().quantity += 1;
            }else{
                CartItem cartItem = new CartItem();
                cartItem.name = product;
                cartItem.quantity = 1;
                cart.add(cartItem);
            }
        }else{
            throw new ProductNotInPriceListException("Product " + product + " doesn't exist in this supermarket!");
        }
    }

    public int total() {
        if(!cart.isEmpty()) {
            AtomicInteger total = new AtomicInteger();
            cart.forEach(cartItem -> {

                PricePolicy pricePolicy = getPricePolicyFor(cartItem.name);
                if(cartItem.quantity < pricePolicy.getNeededForSpecialPrice()){
                    total.addAndGet(pricePolicy.getUnitPrice() * cartItem.quantity);
                }else{
                    int remainingWithoutDiscount = cartItem.quantity % pricePolicy.getNeededForSpecialPrice();
                    int specialPricedBundles = (cartItem.quantity - remainingWithoutDiscount)/pricePolicy.getNeededForSpecialPrice();
                    total.addAndGet(remainingWithoutDiscount * pricePolicy.getUnitPrice());
                    total.addAndGet(specialPricedBundles * pricePolicy.getSpecialPrice());
                }
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
