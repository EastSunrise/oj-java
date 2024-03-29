package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array (EASY)
 *
 * @author Kingen
 * @see Solution1632
 * @see <a href="https://leetcode-cn.com/problems/rank-transform-of-an-array/">Rank Transform of an
 * Array</a>
 */
public class Solution1331 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_N
     */
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> orders = new HashMap<>();
        int order = 1;
        for (int i = 0; i < n; i++) {
            if (!orders.containsKey(sorted[i])) {
                orders.put(sorted[i], order++);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = orders.get(arr[i]);
        }
        return arr;
    }
}
