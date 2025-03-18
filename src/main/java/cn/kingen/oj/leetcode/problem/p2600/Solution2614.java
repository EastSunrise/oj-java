package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/prime-in-diagonal/">2614. Prime In Diagonal</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.MATRIX, Tag.NUMBER_THEORY},
        difficulty = Difficulty.EASY,
        date = "2025-03-18"
)
public class Solution2614 {

    @Complexity(time = "O(n*sqrt(C))", space = "O(1)", note = "C is the max value in diagonal")
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0, x;
        for (int i = 0; i < n; i++) {
            if ((x = nums[i][i]) > ans && isPrime(x)) {
                ans = Math.max(ans, nums[i][i]);
            }
            if ((x = nums[i][n - i - 1]) > ans && isPrime(x)) {
                ans = Math.max(ans, nums[i][n - i - 1]);
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2, im = (int) Math.sqrt(x); i <= im; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}