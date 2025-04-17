package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/">2176. Count Equal and Divisible Pairs in an Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2006
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2364
 */
@Question(
    tags = {Tag.ARRAY},
    difficulty = Difficulty.EASY,
    date = "2025-04-17"
)
public class Solution2176 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}