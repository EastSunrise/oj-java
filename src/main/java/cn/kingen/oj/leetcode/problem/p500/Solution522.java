package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.StringUtils.isSubsequence;

/**
 * <a href="https://leetcode.cn/problems/longest-uncommon-subsequence-ii/">522. Longest Uncommon Subsequence II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution521
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution522 {

    @Complexity(time = "O(l*n^2)", space = "O(1)", note = "l is the average length of strings")
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }
}