package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/">2516. Take K of Each Character From Left and Right</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution88
 * @see cn.kingen.oj.leetcode.problem.p100.Solution143
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1652
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution2516 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int takeCharacters(String s, int k) {
        int n = s.length();
        if (n < 3 * k) {
            return -1;
        }

        int a = 0, b = 0, c = 0;
        int i = 0;
        for (; i < n && (a < k || b < k || c < k); i++) {
            switch (s.charAt(i)) {
                case 'a' -> a++;
                case 'b' -> b++;
                default -> c++;
            }
        }
        if (a < k || b < k || c < k) {
            return -1;
        }

        int ans = i;
        for (int j = n - 1; --i >= 0; ) {
            switch (s.charAt(i)) {
                case 'a' -> a--;
                case 'b' -> b--;
                default -> c--;
            }
            for (; j >= 0 && (a < k || b < k || c < k); j--) {
                switch (s.charAt(j)) {
                    case 'a' -> a++;
                    case 'b' -> b++;
                    default -> c++;
                }
            }
            ans = Math.min(ans, n - j + i - 1);
        }
        return ans;
    }
}