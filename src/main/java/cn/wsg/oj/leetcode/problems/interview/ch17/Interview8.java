package cn.wsg.oj.leetcode.problems.interview.ch17;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 17.8. Circus Tower LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/circus-tower-lcci/">Circus Tower LCCI</a>
 */
public class Interview8 implements Solution {

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            people[i][0] = height[i];
            people[i][1] = weight[i];
        }
        return 0;
    }
}
