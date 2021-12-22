package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution229;

/**
 * 169. Majority Element (Easy)
 *
 * @author Kingen
 * @see Solution229
 * @see Solution1150
 * @see <a href="https://leetcode-cn.com/problems/majority-element/">Majority Element</a>
 */
public class Solution169 implements Solution {

    /**
     * Boyer–Moore majority vote algorithm: delete/nullify two different numbers from the array
     * every time, then the only left number is the majority one.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else if (count == 0) {
                count++;
                major = nums[i];
            } else {
                count--;
            }
        }
        return major;
    }
}
