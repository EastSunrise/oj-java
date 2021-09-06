package wsg.oj.java.leetcode.problems.p900;

import java.util.Arrays;
import java.util.Comparator;
import wsg.oj.java.algorithm.sort.Sorts;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution215;
import wsg.oj.java.leetcode.problems.p300.Solution347;
import wsg.oj.java.leetcode.problems.p600.Solution692;

/**
 * 973. K Closest Points to Origin (MEDIUM)
 *
 * @author Kingen
 * @see Solution215
 * @see Solution347
 * @see Solution692
 * @see Solution1779
 * @see <a href="https://leetcode-cn.com/problems/k-closest-points-to-origin/">K Closest Points to
 * Origin</a>
 * @since 2021-07-27
 */
public class Solution973 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[][] kClosest(int[][] points, int k) {
        Sorts.findKthSmallest(points, k, Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
        return Arrays.copyOf(points, k);
    }
}
