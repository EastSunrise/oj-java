package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-turbulent-subarray/">978. Longest Turbulent Subarray</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution53
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution978 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int down = 1, up = 1, max = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                up = down + 1;
                down = 1;
                max = Math.max(max, up);
            } else if (arr[i - 1] > arr[i]) {
                down = up + 1;
                up = 1;
                max = Math.max(max, down);
            } else {
                up = down = 1;
            }
        }
        return max;
    }
}