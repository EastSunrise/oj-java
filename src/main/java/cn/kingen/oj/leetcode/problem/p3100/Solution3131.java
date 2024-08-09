package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-integer-added-to-array-i/">3131. Find the Integer Added to Array I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution3131 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int addedInteger(int[] nums1, int[] nums2) {
        int max1 = -1, max2 = -1;
        for (int num : nums1) {
            max1 = Math.max(max1, num);
        }
        for (int num : nums2) {
            max2 = Math.max(max2, num);
        }
        return max2 - max1;
    }
}