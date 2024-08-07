package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

import static cn.kingen.oj.leetcode.util.MathUtils.gcd;

/**
 * <a href="https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/">914. X of a Kind in a Deck of Cards</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.COUNTING, Tag.NUMBER_THEORY},
        difficulty = Difficulty.EASY
)
public class Solution914 {

    @Complexity(time = "O(n)", space = "O(n)")
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