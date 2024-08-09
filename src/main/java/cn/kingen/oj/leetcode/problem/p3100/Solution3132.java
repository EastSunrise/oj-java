package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-integer-added-to-array-ii/">3132. Find the Integer Added to Array II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.ENUMERATION, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3132 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int k = 2; k >= 0; k--) {
            int x = nums2[0] - nums1[k], i = nums1.length - 1, j = nums2.length - 1, removed = 0;
            while (j >= 0 && removed <= 2) {
                if (nums1[i] + x != nums2[j]) { // this num is invalid
                    removed++;
                } else {
                    j--;
                }
                i--;
            }
            if (removed <= 2) {
                return x;
            }
        }
        return -1;
    }
}