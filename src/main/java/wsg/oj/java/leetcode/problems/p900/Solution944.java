package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 944. Delete Columns to Make Sorted (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/delete-columns-to-make-sorted/">Delete Columns to
 * Make Sorted</a>
 * @since 2021-07-27
 */
public class Solution944 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
