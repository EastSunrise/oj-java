package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.algorithm.sort.Sorts;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution215;
import cn.wsg.oj.leetcode.problems.p300.Solution347;
import cn.wsg.oj.leetcode.problems.p600.Solution692;
import java.util.Arrays;
import java.util.Comparator;

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
 */
public class Solution973 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[][] kClosest(int[][] points, int k) {
        Sorts.findKthSmallest(points, k, Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
        return Arrays.copyOf(points, k);
    }
}
