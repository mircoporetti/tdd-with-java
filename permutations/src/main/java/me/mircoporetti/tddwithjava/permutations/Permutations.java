package me.mircoporetti.tddwithjava.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Permutations {

    public static List<String> exchange(String word) {
        if(word.length() <= 1) return Collections.singletonList(word);
        else if(word.length() == 2) return distinct(exchangePair(word));
        else{
            List<String> result = new ArrayList<>();
            IntStream.range(0, word.length()).forEach(i -> {
                List<Character> chars = stringToChars(word);
                String head = String.valueOf(chars.get(i));
                chars.remove(i);
                String tail = chars.stream().map(String::valueOf).collect(Collectors.joining());
                List<String> tailPermutations =
                        exchange(tail).stream().map(p -> head + p)
                        .collect(Collectors.toList());
                result.addAll(tailPermutations);
            });
            return distinct(result);
        }
    }

    private static List<String> exchangePair(String twoCharsWord) {
        List<String> permutations = new ArrayList<>();
        permutations.add(twoCharsWord);
        permutations.add(String.valueOf(twoCharsWord.charAt(1)) + twoCharsWord.charAt(0));
        return permutations;
    }

    private static List<Character> stringToChars(String word) {
        List<Character> chars = new ArrayList<>();
        for (char c : word.toCharArray()) chars.add(c);
        return chars;
    }

    private static List<String> distinct(List<String> elements) {
        return elements.stream().distinct().collect(Collectors.toList());
    }
}
