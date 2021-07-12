package wsg.oj.java.leetcode.problems.p200;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 219. Contains Duplicate II (Easy)
 *
 * @author Kingen
 * @see Solution217
 * @see Solution220
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 * @since 2021-07-12
 */
class Solution219 implements Solution {

    /**
     * Builds the map of a number to its last index in the array.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> num2LastIndexMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            Integer oldValue = num2LastIndexMap.put(nums[i], i);
            if (oldValue != null && i - oldValue <= k) {
                return true;
            }
        }
        return false;
    }
}
