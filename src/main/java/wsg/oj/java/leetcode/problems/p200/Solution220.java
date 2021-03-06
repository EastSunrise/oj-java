package wsg.oj.java.leetcode.problems.p200;

import java.util.TreeSet;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 220. Contains Duplicate III (Medium)
 *
 * @author Kingen
 * @see Solution217
 * @see Solution219
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-iii/">Contains Duplicate
 * III</a>
 * @since 2021-07-12
 */
class Solution220 implements Solution {

    /**
     * Slides a window and builds a {@link TreeSet} to keep the numbers within the window.
     *
     * @complexity T=O(nlog_m), m=min(n,k)
     * @complexity S=O(m)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> window = new TreeSet<>();
        // slide the window
        // j: the right (inclusive) index of the window
        for (int j = 0; j < len; j++) {
            Long ceiling = window.ceiling(((long) nums[j] - t));
            if (ceiling != null && ceiling - nums[j] <= t) {
                return true;
            }
            window.add((long) nums[j]);
            if (window.size() == k + 1) {
                window.remove((long) nums[j - k]);
            }
        }
        return false;
    }
}
