package wsg.oj.java.leetcode.problems.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Common methods of String operations.
 *
 * @author Kingen
 * @since 2021/8/16
 */
public interface StringSolution {

    /**
     * Stats the frequency of characters in a string.
     */
    default Map<Character, Integer> stat(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        return counts;
    }
}
