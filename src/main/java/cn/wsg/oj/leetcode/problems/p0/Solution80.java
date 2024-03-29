package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 80. Remove Duplicates from Sorted Array II (Medium)
 *
 * @author Kingen
 * @see Solution26
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/">Remove
 * Duplicates from Sorted Array II</a>
 */
public class Solution80 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int removeDuplicates(int[] nums) {
        int res = 0, cur = nums[0], count = 0;
        for (int num : nums) {
            if (num == cur) {
                count++;
                if (count <= 2) {
                    nums[res++] = cur;
                }
            } else {
                count = 1;
                cur = num;
                nums[res++] = cur;
            }
        }
        return res;
    }
}
