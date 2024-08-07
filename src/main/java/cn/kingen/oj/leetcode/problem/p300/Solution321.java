package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/create-maximum-number/">321. Create Maximum Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution402
 * @see cn.kingen.oj.leetcode.problem.p600.Solution670
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.HARD
)
public class Solution321 {

    @Complexity(time = "O(k*(m+nk*k))", space = "O(k)")
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] max = new int[k], chosen = new int[k], merged = new int[k], tmp;
        for (int k1 = Math.max(0, k - n), end = Math.min(m, k); k1 <= end; k1++) {
            choose(nums1, m, chosen, 0, k1);
            choose(nums2, n, chosen, k1, k);
            merge(merged, k, chosen, k1);
            if (Arrays.compare(merged, max) > 0) {
                tmp = max;
                max = merged;
                merged = tmp;
            }
        }
        return max;
    }

    /**
     * Uses monotonic stack to choose the maximum number and assigns them to the chosen array from the start to the end.
     */
    private void choose(int[] nums, int size, int[] chosen, int start, int end) {
        for (int i = 0, j = start; i < size; i++) {
            while (j > start && end - j < size - i && nums[i] > chosen[j - 1]) {
                j--;
            }
            if (j < end) {
                chosen[j++] = nums[i];
            }
        }
    }

    private void merge(int[] merged, int k, int[] chosen, int k1) {
        int i = 0, j = k1, t = 0;
        while (i < k1 && j < k) {
            if (compare(chosen, k1, i, chosen, k, j) >= 0) {
                merged[t++] = chosen[i++];
            } else {
                merged[t++] = chosen[j++];
            }
        }
        while (i < k1) {
            merged[t++] = chosen[i++];
        }
        while (j < k) {
            merged[t++] = chosen[j++];
        }
    }

    private int compare(int[] nums1, int m, int i, int[] nums2, int n, int j) {
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                return -1;
            } else if (nums1[i] > nums2[j]) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        return i == m ? (j == n ? 0 : -1) : 1;
    }
}