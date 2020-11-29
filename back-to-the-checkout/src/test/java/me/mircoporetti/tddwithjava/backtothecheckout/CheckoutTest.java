package me.mircoporetti.tddwithjava.backtothecheckout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CheckoutTest {

    private Checkout underTest;

    @BeforeEach
    void setUp() {
        HashMap<String, PricePolicy> priceRules = new HashMap<>();
        priceRules.put("A", new PricePolicy(50,3,130));
        priceRules.put("B", new PricePolicy(30,2,45));
        priceRules.put("C", new PricePolicy(20,1,20));
        priceRules.put("D", new PricePolicy(50,1,50));

        underTest = new Checkout(new PriceRuleBook(priceRules));
    }

    @Test
    void emptyCart() {
        int total = underTest.total();

        assertThat(total, is(0));
    }

    @Test
    void oneItemInTheCart() {
        underTest.scan("A");

        int total = underTest.total();

        assertThat(total, is(50));
    }
}