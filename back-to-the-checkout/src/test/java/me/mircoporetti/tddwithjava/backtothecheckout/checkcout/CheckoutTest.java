package me.mircoporetti.tddwithjava.backtothecheckout.checkcout;

import me.mircoporetti.tddwithjava.backtothecheckout.checkout.Checkout;
import me.mircoporetti.tddwithjava.backtothecheckout.checkout.PricePolicy;
import me.mircoporetti.tddwithjava.backtothecheckout.checkout.PriceRuleBook;
import me.mircoporetti.tddwithjava.backtothecheckout.exception.ProductNotInPriceListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void singleProduct() {
        underTest.scan("A");

        int total = underTest.total();

        assertThat(total, is(50));
    }

    @Test
    void productNotInPriceList() {
        assertThrows(ProductNotInPriceListException.class, () -> underTest.scan("Z"));
    }

    @Test
    void oneForEachProduct() {
        underTest.scan("A");
        underTest.scan("B");
        underTest.scan("C");
        underTest.scan("D");

        int total = underTest.total();

        assertThat(total, is(150));
    }

    @Test
    void twoForAProductAndOneForAnother() {
        underTest.scan("A");
        underTest.scan("A");
        underTest.scan("B");

        int total = underTest.total();

        assertThat(total, is(130));
    }

    @Test
    void specialPriceForAProduct() {
        underTest.scan("A");
        underTest.scan("A");
        underTest.scan("A");

        int total = underTest.total();

        assertThat(total, is(130));
    }

    @Test
    void specialPriceForMultipleProducts() {
        underTest.scan("A");
        underTest.scan("A");
        underTest.scan("A");
        underTest.scan("B");
        underTest.scan("B");

        int total = underTest.total();

        assertThat(total, is(175));
    }
}