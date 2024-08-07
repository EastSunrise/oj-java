package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/">1619. Mean of Array After Removing Some Elements</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution1619 {

    @Complexity(time = "O(n)", space = "O(1)")
    public double trimMean(int[] arr) {
        int n = arr.length;
        int start = n / 20, end = n - start;
        findKthSmallest(arr, start, 0, n - 1);
        findKthSmallest(arr, end, start, n - 1);
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / (end - start);
    }
}