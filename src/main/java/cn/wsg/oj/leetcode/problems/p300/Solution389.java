package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution136;

/**
 * 389. Find the Difference (Easy)
 *
 * @author Kingen
 * @see Solution136
 * @see <a href="https://leetcode-cn.com/problems/find-the-difference/">Find the Difference</a>
 */
public class Solution389 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum ^= c;
        }
        for (char c : t.toCharArray()) {
            sum ^= c;
        }
        return (char) sum;
    }
}
