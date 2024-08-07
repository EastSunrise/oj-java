package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/k-closest-points-to-origin/">973. K Closest Points to Origin</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution215
 * @see cn.kingen.oj.leetcode.problem.p300.Solution347
 * @see cn.kingen.oj.leetcode.problem.p600.Solution692
 */
@Question(
        tags = {Tag.GEOMETRY, Tag.ARRAY, Tag.MATH, Tag.DIVIDE_AND_CONQUER, Tag.QUICKSELECT, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution973 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[][] kClosest(int[][] points, int k) {
        findKthSmallest(points, k, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}