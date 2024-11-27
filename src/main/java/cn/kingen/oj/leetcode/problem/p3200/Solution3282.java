package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reach-end-of-array-with-max-score/">3282. Reach End of Array With Max Score</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.MEDIUM
)
public class Solution3282 {

    /**
     * Jumps to next larger value.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long max = nums.getFirst(), score = 0;
        for (int i = 1; i < n; i++) {
            score += max;
            max = Math.max(max, nums.get(i));
        }
        return score;
    }
}