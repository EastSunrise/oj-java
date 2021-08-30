package wsg.oj.java.leetcode.problems.offer;

import java.util.Arrays;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 45. 把数组排成最小的数 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/">把数组排成最小的数
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer45 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
            .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1)).collect(Collectors.joining());
    }
}
