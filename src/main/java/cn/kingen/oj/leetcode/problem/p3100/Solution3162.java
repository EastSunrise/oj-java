package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-number-of-good-pairs-i/">3162. Find the Number of Good Pairs I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2183
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution3162 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int ans = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 % (num2 * k) == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}