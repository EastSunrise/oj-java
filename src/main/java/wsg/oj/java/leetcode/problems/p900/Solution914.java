package wsg.oj.java.leetcode.problems.p900;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 914. X of a Kind in a Deck of Cards (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/">X of a Kind in a
 * Deck of Cards</a>
 * @since 2021-07-27
 */
public class Solution914 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> counts = new HashMap<>(4);
        for (int num : deck) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int gcd = 0;
        for (int count : counts.values()) {
            gcd = gcd(gcd, count);
            if (gcd < 2) {
                return false;
            }
        }
        return true;
    }
}
