package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency/">3144. Minimum Substring Partition of Equal Character Frequency</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1043
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2767
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.DYNAMIC_PROGRAMMING, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3144 {

    @Complexity(time = "O(n^2)", space = "O(C*n)", note = "C is the size of character set")
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        return dfs(new int[n], s.toCharArray(), n - 1);
    }

    private int dfs(int[] memo, char[] chars, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }

        int ans = Integer.MAX_VALUE;
        int[] freq = new int[26];
        int distinct = 0, maxCnt = 0;
        for (int j = i; j >= 0; j--) {
            int ch = chars[j] - 'a';
            if (freq[ch] == 0) { // a new character
                distinct++;
            }
            freq[ch]++;
            maxCnt = Math.max(maxCnt, freq[ch]);
            if (distinct * maxCnt == i - j + 1) { // all characters are of the same frequency: maxCnt
                ans = Math.min(ans, dfs(memo, chars, j - 1) + 1);
            }
        }
        return memo[i] = ans;
    }
}