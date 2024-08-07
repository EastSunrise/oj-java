package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/special-array-ii/">3152. Special Array II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution3152 {

    @Complexity(time = "O(m+n)", space = "O(n)")
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        // start[i]: the first index of the special array ending with nums[i].
        int[] start = new int[n];
        start[0] = 0;
        int r = nums[0] & 1;
        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) == r) {
                start[i] = i;
            } else {
                start[i] = start[i - 1];
                r ^= 1;
            }
        }
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int from = queries[i][0], to = queries[i][1];
            ans[i] = start[to] <= from;
        }
        return ans;
    }
}