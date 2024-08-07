package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/faulty-keyboard/">2810. Faulty Keyboard</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution345
 * @see cn.kingen.oj.leetcode.problem.p500.Solution541
 * @see cn.kingen.oj.leetcode.problem.p900.Solution917
 */
@Question(
        tags = {Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2810 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String finalString(String s) {
        int n = s.length(), low = 0, high = n - 1;
        char[] chars = new char[n];
        boolean reversed = false;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'i') {
                reversed = !reversed;
            } else if (reversed) {
                chars[high--] = ch;
            } else {
                chars[low++] = ch;
            }
        }
        StringBuilder sb = new StringBuilder(n);
        if (reversed) {
            while (--low >= 0) {
                sb.append(chars[low]);
            }
            for (int i = n - 1; i > high; i--) {
                sb.append(chars[i]);
            }
        } else {
            while (++high < n) {
                sb.append(chars[high]);
            }
            for (int i = 0; i < low; i++) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}