package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sub-sort-lcci/">面试题 16.16. Sub Sort LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Interview16 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] subSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return new int[]{-1, -1};
        }
        int start = n - 1, min = array[start];
        for (int k = n - 2; k >= 0; k--) {
            if (array[k] > min) { // not ordered
                start = k;
            } else {
                min = array[k];
            }
        }
        int end = 0, max = array[end];
        for (int k = 1; k < n; k++) {
            if (array[k] < max) { // not ordered
                end = k;
            } else {
                max = array[k];
            }
        }
        if (start > end) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end};
    }
}