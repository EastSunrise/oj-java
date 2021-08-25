package wsg.oj.java.leetcode.problems.p300;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution402;
import wsg.oj.java.leetcode.problems.p600.Solution670;

/**
 * 321. Create Maximum Number (HARD)
 *
 * @author Kingen
 * @see Solution402
 * @see Solution670
 * @see <a href="https://leetcode-cn.com/problems/create-maximum-number/">Create Maximum Number</a>
 * @since 2021-07-27
 */
public class Solution321 implements Solution {

    /**
     * @complexity T=O(k(m+n+k*k))
     * @complexity S=O(k)
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int k1 = Math.max(0, k - n), kLen = Math.min(m, k);
        int[] max = new int[k], chosen = new int[k], merged = new int[k];
        while (k1 <= kLen) {
            choose(nums1, m, chosen, 0, k1);
            choose(nums2, n, chosen, k1, k);
            merge(chosen, k1, merged, k);
            if (Arrays.compare(merged, max) > 0) {
                int[] tmp = max;
                max = merged;
                merged = tmp;
            }
            k1++;
        }
        return max;
    }

    private void merge(int[] chosen, int k1, int[] merged, int k) {
        int i = 0, j = k1;
        for (int r = 0; r < k; r++) {
            if (Arrays.compare(chosen, i, k1, chosen, j, k) > 0) {
                merged[r] = chosen[i++];
            } else {
                merged[r] = chosen[j++];
            }
        }
    }

    private void choose(int[] nums, int n, int[] chosen, int start, int end) {
        int i = 0, j = start;
        while (i < n) {
            while (j > start && end - j < n - i && nums[i] > chosen[j - 1]) {
                j--;
            }
            if (j < end) {
                chosen[j++] = nums[i];
            }
            i++;
        }
    }
}
