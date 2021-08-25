package wsg.oj.java.leetcode.problems.p1100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1122. Relative Sort Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/relative-sort-array/">Relative Sort Array</a>
 * @since 2021-07-27
 */
public class Solution1122 implements Solution {

    /**
     * @complexity T=O(n+m*log{m}), m=the length of arr1
     * @complexity S=O(m+n)
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr2.length;
        Map<Integer, Integer> indices = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indices.put(arr2[i], i);
        }
        return Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            int i1 = indices.getOrDefault(o1, Integer.MAX_VALUE);
            int i2 = indices.getOrDefault(o2, Integer.MAX_VALUE);
            return i1 == i2 ? Integer.compare(o1, o2) : i1 - i2;
        }).mapToInt(t -> t).toArray();
    }
}
