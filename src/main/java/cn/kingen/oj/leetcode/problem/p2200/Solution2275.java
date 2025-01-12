package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/">2275. Largest
 * Combination With Bitwise AND Greater Than Zero</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2044
 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING},
    difficulty = Difficulty.MEDIUM,
    daily = "2025-01-12"
)
public class Solution2275 {

    @Complexity(time = "O(C*n)", space = "O(1)", note = "C is 32")
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for (int i = 0; i < 24; i++) {
            int mask = 1 << i, cnt = 0;
            for (int candidate : candidates) {
                if ((candidate & mask) != 0) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}