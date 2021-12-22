package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II (Easy)
 *
 * @author Kingen
 * @see Solution217
 * @see Solution220
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 */
public class Solution219 implements Solution {

    /**
     * Builds the map of a number to its last index in the array.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
