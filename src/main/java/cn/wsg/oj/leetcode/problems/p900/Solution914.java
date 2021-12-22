package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/">X of a Kind in a
 * Deck of Cards</a>
 */
public class Solution914 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
