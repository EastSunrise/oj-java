package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 997. Find the Town Judge (EASY)
 *
 * @author Kingen
 * @see Solution277
 * @see <a href="https://leetcode-cn.com/problems/find-the-town-judge/">Find the Town Judge</a>
 * @since 2021-07-27
 */
public class Solution997 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];
        for (int[] entry : trust) {
            trusts[entry[0]]++;
            trusted[entry[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0) {
                return trusted[i] + 1 == n ? i : -1;
            }
        }
        return -1;
    }
}
