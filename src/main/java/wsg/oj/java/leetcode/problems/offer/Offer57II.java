package wsg.oj.java.leetcode.problems.offer;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 57-II. 和为s的连续正数序列 LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/">和为s的连续正数序列
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer57II implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> sequences = new ArrayList<>();
        int max = (int) Math.sqrt(2 * target);
        for (int k = max; k > 1; k--) {
            int base = target - (k - 1) * k / 2;
            if (base % k == 0) {
                int[] seq = new int[k];
                seq[0] = base / k;
                for (int i = 1; i < k; i++) {
                    seq[i] = seq[i - 1] + 1;
                }
                sequences.add(seq);
            }
        }
        return sequences.toArray(new int[0][]);
    }
}
