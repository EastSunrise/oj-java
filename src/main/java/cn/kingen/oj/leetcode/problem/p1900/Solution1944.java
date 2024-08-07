package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue/">1944. Number of Visible People in a Queue</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1762
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2104
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2281
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2282
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2940
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.HARD
)
public class Solution1944 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = top;
            while (top >= 0 && heights[i] > stack[top]) {
                top--;
            }
            ans[i] = tmp - top + (top < 0 ? 0 : 1);
            stack[++top] = heights[i];
        }
        return ans;
    }
}