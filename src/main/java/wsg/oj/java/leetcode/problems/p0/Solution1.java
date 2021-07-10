package wsg.oj.java.leetcode.problems.p0;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1. Two Sum (Easy)
 *
 * @author Kingen
 * @see Solution15
 * @see Solution18
 * @see Solution167
 * @see Solution170
 * @see Solution560
 * @see Solution653
 * @see Solution1099
 * @see Solution1679
 * @see Solution1711
 * @see <a href="https://leetcode-cn.com/problems/two-sum/">Two Sum</a>
 * @since 2021-07-10
 */
class Solution1 implements Solution {

    /**
     * Finds the other number with a map.
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            int other = target - num;
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(num, i);
        }
        throw new IllegalArgumentException("no such two numbers.");
    }
}
