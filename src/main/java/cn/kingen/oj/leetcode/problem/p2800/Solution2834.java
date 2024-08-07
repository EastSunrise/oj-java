package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/">2834. Find the Minimum Possible Sum of a Beautiful Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution2834 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int minimumPossibleSum(int n, int target) {
        if (target >= n << 1) {
            return (int) (((long) n * (n + 1) >> 1) % MOD);
        }
        int half = target >> 1;
        long left = (long) half * (half + 1) >> 1;
        long right = ((long) target + target + n - half - 1) * (n - half) >> 1;
        return (int) ((left + right) % MOD);
    }
}