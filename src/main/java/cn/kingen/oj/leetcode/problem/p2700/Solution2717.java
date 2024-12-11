package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/semi-ordered-permutation/">2717. Semi-Ordered Permutation</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2717 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                a = i;
            } else if (nums[i] == n) {
                b = i;
            }
        }
        return a < b ? a + n - 1 - b : a + n - b - 2;
    }
}