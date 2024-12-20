package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.gcd;

/**
 * <a href="https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/">3138. Minimum Length of Anagram Concatenation</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3138 {

    @Complexity(time = "O(A*n)", space = "O(C)", note = "A is the number of divisors, C is 26")
    public int minAnagramLength(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        int gcd = n;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                gcd = gcd(gcd, cnt[i]);
            }
        }

        for (int p = gcd, q = 1; p > 1; ) { // divide s into p parts
            if (p * q == gcd) {
                if (check(s, n, n / p)) {
                    return n / p;
                }
            }
            p = Math.min(p - 1, gcd / (q + 1));
            q = gcd / p;
        }
        return n;
    }

    private boolean check(String s, int n, int len) {
        int[] base = new int[26];
        for (int i = 0; i < len; i++) {
            base[s.charAt(i) - 'a']++;
        }

        int[] counts = new int[26];
        for (int i = len; i < n; i += len) {
            System.arraycopy(base, 0, counts, 0, 26);
            for (int j = 0; j < len; j++) {
                int ch = s.charAt(i + j) - 'a';
                if (--counts[ch] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}