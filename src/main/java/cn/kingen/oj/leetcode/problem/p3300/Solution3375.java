package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-array-values-equal-to-k/">3375. Minimum Operations
 * to Make Array Values Equal to K</a>
 *
 * @author Kingen
 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE},
    difficulty = Difficulty.EASY,
    date = "2025-04-09"
)
public class Solution3375 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minOperations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.add(num)) {
                min = Math.min(min, num);
            }
        }
        return k < min ? unique.size() : k == min ? unique.size() - 1 : -1;
    }
}