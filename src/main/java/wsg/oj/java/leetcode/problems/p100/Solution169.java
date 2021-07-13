package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution229;

/**
 * 169. Majority Element (Easy)
 *
 * @author Kingen
 * @see Solution229
 * @see Solution1150
 * @see <a href="https://leetcode-cn.com/problems/majority-element/">Majority Element</a>
 * @since 2021-07-12
 */
public class Solution169 implements Solution {

    /**
     * Boyer–Moore majority vote algorithm: delete/nullify two different numbers from the array
     * every time, then the only left number is the majority one.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
