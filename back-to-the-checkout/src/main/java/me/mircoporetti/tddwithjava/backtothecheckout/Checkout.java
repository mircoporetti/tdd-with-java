package me.mircoporetti.tddwithjava.backtothecheckout;

public class Checkout {

    private final PriceRuleBook priceRuleBook;
    private int total;

    public Checkout(PriceRuleBook priceRuleBook) {
        this.priceRuleBook = priceRuleBook;
    }

    public void scan(String product) {
        PricePolicy pricePolicy = priceRuleBook.getRules().get("A");
        total = pricePolicy.getUnitPrice();
    }

    public int total() {
        return total;
    }
}
