package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 51. 数组中的逆序对  LCOF (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/">数组中的逆序对  LCOF</a>
 * @since 2021-07-28
 */
public class Offer51 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length, new int[nums.length]);
    }

    private int sort(int[] nums, int fromIn, int toEx, int[] tmp) {
        if (toEx - fromIn <= 1) {
            return 0;
        }
        int mid = (fromIn + toEx) / 2;
        int cnt = sort(nums, fromIn, mid, tmp) + sort(nums, mid, toEx, tmp);
        int i = fromIn, j = mid, t = 0;
        while (i < mid && j < toEx) {
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                cnt += mid - i;
                tmp[t++] = nums[j++];
            }
        }
        while (i < mid) {
            tmp[t++] = nums[i++];
        }
        while (j < toEx) {
            tmp[t++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, fromIn, t);
        return cnt;
    }
}
