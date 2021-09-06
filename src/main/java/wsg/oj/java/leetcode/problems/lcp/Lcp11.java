package wsg.oj.java.leetcode.problems.lcp;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 11. 期望个数统计 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/qi-wang-ge-shu-tong-ji/">期望个数统计</a>
 * @since 2021-07-28
 */
public class Lcp11 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int expectNumber(int[] scores) {
        return (int) Arrays.stream(scores).distinct().count();
    }
}
