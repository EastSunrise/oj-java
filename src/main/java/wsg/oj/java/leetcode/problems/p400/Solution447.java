package wsg.oj.java.leetcode.problems.p400;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 447. Number of Boomerangs (Medium)
 *
 * @author Kingen
 * @see Solution356
 * @see <a href="https://leetcode-cn.com/problems/number-of-boomerangs/">Number of Boomerangs</a>
 * @since 2021-07-08
 */
public class Solution447 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] pi : points) {
            Map<Integer, Integer> counts = new HashMap<>(16);
            for (int[] pj : points) {
                int distance = (int) (Math.pow(pj[0] - pi[0], 2) + Math.pow(pj[1] - pi[1], 2));
                counts.put(distance, counts.getOrDefault(distance, 0) + 1);
            }
            for (int count : counts.values()) {
                res += count * (count - 1);
            }
        }
        return res;
    }
}
