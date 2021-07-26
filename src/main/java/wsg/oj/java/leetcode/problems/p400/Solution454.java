package wsg.oj.java.leetcode.problems.p400;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution18;

/**
 * 454. 4Sum II (Medium)
 *
 * @author Kingen
 * @see Solution18
 * @see <a href="https://leetcode-cn.com/problems/4sum-ii/">4Sum II</a>
 * @since 2021-07-08
 */
public class Solution454 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#TIME_NN
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> sums12 = new HashMap<>(16);
        Map<Integer, Integer> sums34 = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum12 = nums1[i] + nums2[j];
                sums12.put(sum12, sums12.getOrDefault(sum12, 0) + 1);
                int sum34 = nums3[i] + nums4[j];
                sums34.put(sum34, sums34.getOrDefault(sum34, 0) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sums12.entrySet()) {
            count += entry.getValue() * sums34.getOrDefault(-entry.getKey(), 0);
        }
        return count;
    }
}
