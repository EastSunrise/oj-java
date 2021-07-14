package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 500. Keyboard Row (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/keyboard-row/">Keyboard Row</a>
 * @since 2021-07-13
 */
class Solution500 implements Solution {

    static char[][] keyboard = new char[][]{
        {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
        {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'},
        {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}
    };
    static int[] rows = new int[26];

    static {
        for (int i = 0; i < keyboard.length; i++) {
            for (char ch : keyboard[i]) {
                rows[ch - 'A'] = i;
            }
        }
    }

    /**
     * @complexity T=O(L), L=sum(len(word))
     * @complexity S=O(26)
     */
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isSameRow(word, rows)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean isSameRow(String word, int[] rows) {
        char[] chars = word.toCharArray();
        int row = rows[chars[0] > 'Z' ? (chars[0] - 'a') : chars[0] - 'A'];
        for (int i = chars.length - 1; i > 0; i--) {
            char ch = chars[i];
            if (rows[ch > 'Z' ? ch - 'a' : ch - 'A'] != row) {
                return false;
            }
        }
        return true;
    }
}
