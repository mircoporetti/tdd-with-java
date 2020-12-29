package me.mircoporetti.tddwithjava.permutations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PermutationsTest {

    @Test
    void permutations() {
        assertThat(Permutations.exchange("a"), is(Collections.singletonList("a")));
        assertThat(Permutations.exchange("ab"), is(Arrays.asList("ab","ba")));
        assertThat(Permutations.exchange("aa"), is(Collections.singletonList("aa")));
        assertThat(Permutations.exchange("abc"), is(Arrays.asList("abc","acb","bac","bca","cab","cba")));
        assertThat(Permutations.exchange("aabb"), is(Arrays.asList("aabb","abab","abba","baab","baba","bbaa")));
    }
}
