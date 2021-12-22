package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * LCP 11. 期望个数统计 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/qi-wang-ge-shu-tong-ji/">期望个数统计</a>
 */
public class Lcp11 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int expectNumber(int[] scores) {
        return (int) Arrays.stream(scores).distinct().count();
    }
}
