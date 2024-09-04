package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/hand-of-straights/">846. Hand of Straights</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution846 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : hand) {
            freq.merge(num, 1, Integer::sum);
        }

        for (int x : hand) {
            if (!freq.containsKey(x)) { // used
                continue;
            }
            int last = x + groupSize - 1;
            while (x <= last) {
                Integer cnt = freq.get(x);
                if (cnt == null) {
                    return false;
                } else if (cnt == 1) {
                    freq.remove(x);
                } else {
                    freq.put(x, cnt - 1);
                }
                x++;
            }
        }
        return true;
    }
}