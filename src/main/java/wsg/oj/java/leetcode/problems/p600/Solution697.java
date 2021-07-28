package wsg.oj.java.leetcode.problems.p600;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution53;

/**
 * 697. Degree of an Array (EASY)
 *
 * @author Kingen
 * @see Solution53
 * @see <a href="https://leetcode-cn.com/problems/degree-of-an-array/">Degree of an Array</a>
 * @since 2021-07-23
 */
public class Solution697 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int findShortestSubArray(int[] nums) {
        // value: count of the key, first index, last index
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                value[0]++;
                value[2] = i;
            }
        }
        int degree = 0, res = nums.length;
        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                res = value[2] - value[1];
            } else if (value[0] == degree) {
                res = Math.min(value[2] - value[1], res);
            }
        }
        return res + 1;
    }
}
