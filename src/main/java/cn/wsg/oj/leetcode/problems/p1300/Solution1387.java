package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1387. Sort Integers by The Power Value (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sort-integers-by-the-power-value/">Sort Integers
 * by The Power Value</a>
 */
public class Solution1387 implements Solution {

    /**
     * @complexity T=O(W*n*log{n}), W=the maximal weight, n=hi-lo+1
     * @complexity S=O(n)
     */
    public int getKth(int lo, int hi, int k) {
        int[][] arr = new int[hi - lo + 1][];
        for (int i = lo; i <= hi; i++) {
            arr[i - lo] = new int[]{getWeight(i), i};
        }
        Arrays.sort(arr, Comparator.<int[], Integer>comparing(a -> a[0]).thenComparing(a -> a[1]));
        return arr[k - 1][1];
    }

    private int getWeight(int x) {
        int weight = 0;
        while (x != 1) {
            x = x % 2 == 0 ? x / 2 : 3 * x + 1;
            weight++;
        }
        return weight;
    }
}
