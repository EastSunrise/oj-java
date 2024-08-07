package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-the-distinct-difference-array/">2670. Find the Distinct Difference Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2574
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution2670 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        Set<Integer> prefix = new HashSet<>(), suffix = new HashSet<>();
        for (int i = 0; i < n; i++) {
            prefix.add(nums[i]);
            diff[i] = prefix.size();
        }
        for (int i = n - 1; i >= 0; i--) {
            diff[i] -= suffix.size();
            suffix.add(nums[i]);
        }
        return diff;
    }
}