package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution136;
import cn.wsg.oj.leetcode.problems.p100.Solution142;

/**
 * 287. Find the Duplicate Number (Medium)
 *
 * @author Kingen
 * @see Solution41
 * @see Solution136
 * @see Solution142
 * @see Solution268
 * @see Solution645
 * @see <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/">Find the Duplicate
 * Number</a>
 */
public class Solution287 implements Solution {

    /**
     * If the number at index i points to the number at index nums[i], the numbers will form a
     * linked list. Then the duplicate numbers will form a cycle.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (fast != slow);
        return fast;
    }
}
