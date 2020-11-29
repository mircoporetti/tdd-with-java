package me.mircoporetti.tddwithjava.backtothecheckout.checkout;

public class PricePolicy {
    private final int unitPrice;
    private final int neededForSpecialPrice;
    private final int specialPrice;

    public PricePolicy(int unitPrice, int neededForSpecialPrice, int specialPrice) {
        this.unitPrice = unitPrice;
        this.neededForSpecialPrice = neededForSpecialPrice;
        this.specialPrice = specialPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getNeededForSpecialPrice() {
        return neededForSpecialPrice;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }
}
