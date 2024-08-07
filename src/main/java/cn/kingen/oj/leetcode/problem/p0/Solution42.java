package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution11
 * @see cn.kingen.oj.leetcode.problem.p200.Solution238
 * @see cn.kingen.oj.leetcode.problem.p400.Solution407
 * @see cn.kingen.oj.leetcode.problem.p700.Solution755
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.TWO_POINTERS, Tag.DYNAMIC_PROGRAMMING, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.HARD
)
public class Solution42 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}