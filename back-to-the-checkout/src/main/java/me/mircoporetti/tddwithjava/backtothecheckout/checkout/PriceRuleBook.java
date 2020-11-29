package me.mircoporetti.tddwithjava.backtothecheckout.checkout;

import java.util.HashMap;
import java.util.Objects;

public class PriceRuleBook {
    private final HashMap<String, PricePolicy> rules;

    public PriceRuleBook(HashMap<String, PricePolicy> rules) {
        this.rules = rules;
    }

    public HashMap<String, PricePolicy> getRules() {
        return rules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceRuleBook that = (PriceRuleBook) o;
        return Objects.equals(rules, that.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rules);
    }
}
