package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution203;
import cn.wsg.oj.leetcode.problems.p200.Solution283;

/**
 * 27. Remove Element (Easy)
 *
 * @author Kingen
 * @see Solution26
 * @see Solution203
 * @see Solution283
 * @see <a href="https://leetcode-cn.com/problems/remove-element/">Remove Element</a>
 */
public class Solution27 implements Solution {

    /**
     * It's similar to {@link Solution26}. Use two pointers to copy different numbers in-place.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
