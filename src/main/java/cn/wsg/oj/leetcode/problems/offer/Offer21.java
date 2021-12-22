package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">调整数组顺序使奇数位于偶数前面
 * LCOF</a>
 */
public class Offer21 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
            } else if (nums[right] % 2 == 0) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }
}
