package wsg.oj.java.leetcode.problems.p500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 506. Relative Ranks (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/relative-ranks/">Relative Ranks</a>
 * @since 2021-07-20
 */
class Solution506 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String[] findRelativeRanks(int[] scores) {
        int len = scores.length;
        int[] copy = Arrays.copyOf(scores, len);
        Arrays.sort(copy);
        Map<Integer, Integer> ranks = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            ranks.put(copy[i], len - i);
        }
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            int rank = ranks.get(scores[i]);
            if (rank > 3) {
                res[i] = String.valueOf(rank);
            } else {
                if (rank == 1) {
                    res[i] = "Gold Medal";
                } else if (rank == 2) {
                    res[i] = "Silver Medal";
                } else if (rank == 3) {
                    res[i] = "Bronze Medal";
                }
            }
        }
        return res;
    }
}
