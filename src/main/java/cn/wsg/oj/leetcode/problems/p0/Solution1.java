package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution167;
import cn.wsg.oj.leetcode.problems.p1600.Solution1679;
import cn.wsg.oj.leetcode.problems.p1700.Solution1711;
import cn.wsg.oj.leetcode.problems.p500.Solution560;
import cn.wsg.oj.leetcode.problems.p600.Solution653;
import java.util.HashMap;
import java.util.Map;

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
 */
public class Solution1 implements Solution {

    /**
     * Finds the other number with a map.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such two numbers.");
    }
}
