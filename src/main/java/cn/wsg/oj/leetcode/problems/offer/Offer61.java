package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子  LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/">扑克牌中的顺子
 * LCOF</a>
 */
public class Offer61 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean isStraight(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while (i < n && nums[i] == 0) {
            i++;
        }
        if (i == n) {
            return true;
        }
        if (nums[n - 1] - nums[i] >= n) {
            return false;
        }
        while (++i < n) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
