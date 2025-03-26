package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-generated-string/">3474. Lexicographically Smallest Generated String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1061

 */
@Question(
        difficulty = Difficulty.HARD,
        contest = 439
)
public class Solution3474 {

    @Complexity(time = "O(mn)", space = "O(m+n)")
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] chars2 = str2.toCharArray();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '#');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != 'T') {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (ans[j + i] == '#') {
                    ans[j + i] = chars2[j];
                } else if (ans[j + i] != chars2[j]) {
                    return "";
                }
            }
        }

        boolean[] unfixed = new boolean[n + m - 1];
        for (int i = 0; i < n + m - 1; i++) { // fill the unfixed chars with 'a'
            if (ans[i] == '#') {
                ans[i] = 'a';
                unfixed[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != 'F') {
                continue;
            }
            if (!Arrays.equals(chars2, 0, m, ans, i, i + m)) {
                continue;
            }

            int lastUnfixed = -1;
            for (int j = i + m - 1; j >= i; j--) { // find the last unfixed char
                if (unfixed[j]) {
                    lastUnfixed = j;
                    break;
                }
            }
            if (lastUnfixed == -1) {
                return "";
            }
            ans[lastUnfixed] = 'b';
        }
        return new String(ans);
    }
}