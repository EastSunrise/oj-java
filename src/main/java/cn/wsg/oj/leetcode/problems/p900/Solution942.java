package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 942. DI String Match (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/di-string-match/">DI String Match</a>
 */
public class Solution942 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        int low = 0, high = n;
        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        res[n] = low;
        return res;
    }
}
