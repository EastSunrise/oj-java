package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.p0.Solution75;
import cn.wsg.oj.leetcode.problems.p200.Solution215;
import java.util.Arrays;

/**
 * 324. Wiggle Sort II (Medium)
 *
 * @author Kingen
 * @see Solution75
 * @see Solution215
 * @see Solution280
 * @see <a href="https://leetcode-cn.com/problems/wiggle-sort-ii/">Wiggle Sort II</a>
 */
public class Solution324 extends Solution215 {

    /**
     * Quick selection.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int mid = (len + 1) / 2;
        findKthLargest(nums, mid);
        // insert nums[mid,len) into nums[0,mid)
        int left = mid - 1, right = nums.length - 1;
        int[] copy = Arrays.copyOf(nums, len);
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                nums[i] = copy[left--];
            } else {
                nums[i] = copy[right--];
            }
        }
    }
}
