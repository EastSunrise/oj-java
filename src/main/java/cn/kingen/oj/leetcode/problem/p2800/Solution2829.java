package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/determine-the-minimum-sum-of-a-k-avoiding-array/">2829. Determine the Minimum Sum of a k-avoiding Array</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GREEDY, Tag.MATH},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-26"
)
public class Solution2829 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int minimumSum(int n, int k) {
        int h = k >> 1;
        if (n <= h) { // choose 1,...,n
            return (n + 1) * n / 2;
        }
        // choose 1,...,h,k,...
        return (h + 1) * h / 2 + (2 * k + n - h - 1) * (n - h) / 2;
    }
}