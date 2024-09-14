package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-increasing-quadruplets/">2552. Count Increasing Quadruplets</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution334
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1995
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2179
 */
@Question(
        tags = {Tag.BINARY_INDEXED_TREE, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.ENUMERATION, Tag.PREFIX_SUM},
        difficulty = Difficulty.HARD
)
public class Solution2552 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        // lower[j][x] is the count of numbers in nums[0...j-1] that are less than x.
        // higher[k][y] is the count of numbers in nums[k+1...n-1] that are greater than y.
        int[][] lower = new int[n][n + 1], higher = new int[n][n + 1];
        for (int j = 1; j < n; j++) {
            int up = nums[j - 1];
            for (int x = 1; x <= n; x++) {
                lower[j][x] = lower[j - 1][x];
                if (up < x) {
                    lower[j][x]++;
                }
            }
        }
        for (int k = n - 2; k >= 0; k--) {
            int down = nums[k + 1];
            for (int y = 1; y <= n; y++) {
                higher[k][y] = higher[k + 1][y];
                if (down > y) {
                    higher[k][y]++;
                }
            }
        }
        long ans = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[j] > nums[k]) {
                    ans += (long) lower[j][nums[k]] * higher[k][nums[j]];
                }
            }
        }
        return ans;
    }
}