package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. Two Sum</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution15
 * @see cn.kingen.oj.leetcode.problem.p0.Solution18
 * @see cn.kingen.oj.leetcode.problem.p100.Solution167
 * @see cn.kingen.oj.leetcode.problem.p100.Solution170
 * @see cn.kingen.oj.leetcode.problem.p500.Solution560
 * @see cn.kingen.oj.leetcode.problem.p600.Solution653
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1099
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution1 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such two numbers.");
    }
}