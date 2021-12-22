package cn.wsg.oj.leetcode.problems.p1900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1929. Concatenation of Array (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/concatenation-of-array/">Concatenation of
 * Array</a>
 */
public class Solution1929 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[n * 2];
        System.arraycopy(nums, 0, res, 0, n);
        System.arraycopy(nums, 0, res, n, n);
        return res;
    }
}
