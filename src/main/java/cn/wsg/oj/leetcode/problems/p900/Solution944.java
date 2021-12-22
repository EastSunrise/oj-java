package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 944. Delete Columns to Make Sorted (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/delete-columns-to-make-sorted/">Delete Columns to
 * Make Sorted</a>
 */
public class Solution944 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
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
