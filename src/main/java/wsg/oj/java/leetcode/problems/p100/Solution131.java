package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 131. Palindrome Partitioning (Medium)
 *
 * @author Kingen
 * @see Solution132
 * @see Solution1745
 * @see <a href="https://leetcode-cn.com/problems/palindrome-partitioning/">Palindrome
 * Partitioning</a>
 * @since 2021-07-11
 */
class Solution131 implements Solution {

    /**
     * @complexity T=O(n*2^n)
     * @see wsg.oj.java.Complexity#SPACE_2_N
     * @see #DYNAMIC_PROGRAMMING
     * @see #DFS
     */
    public List<List<String>> partition(String s) {
        int len = s.length();
        // i: the start index of the substring
        // c: the length of the substring
        // res[i][c]: whether s[i,i+c) is palindrome
        boolean[][] flags = new boolean[len][len + 1];
        for (int i = 0; i < len; i++) {
            // the length of the substring is 1
            flags[i][0] = true;
            flags[i][1] = true;
        }
        for (int c = 2; c <= len; c++) {
            for (int i = 0, n = len - c; i <= n; i++) {
                flags[i][c] = s.charAt(i) == s.charAt(i + c - 1) && flags[i + 1][c - 2];
            }
        }

        List<List<String>> res = new ArrayList<>();
        partition(res, s.toCharArray(), flags, new ArrayList<>(), 0);
        return res;
    }

    private void partition(List<List<String>> res, char[] chars, boolean[][] flags,
        List<String> temp, int start) {
        if (start == chars.length) {
            // reach the end
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int c = 1, maxCount = chars.length - start; c <= maxCount; c++) {
            if (flags[start][c]) {
                temp.add(new String(chars, start, c));
                partition(res, chars, flags, temp, start + c);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
