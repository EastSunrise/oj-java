package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/">3396.
 * Minimum Number of Operations to Make Elements in Array Distinct</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution945
 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE},
    difficulty = Difficulty.EASY,
    date = "2025-04-08"
)
public class Solution3396 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = nums.length - 1;
        while (i >= 0 && set.add(nums[i])) {
            i--;
        }
        return i < 0 ? 0 : i / 3 + 1;
    }
}