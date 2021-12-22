package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification (HARD)
 *
 * @author Kingen
 * @see Solution1592
 * @see <a href="https://leetcode-cn.com/problems/text-justification/">Text Justification</a>
 */
public class Solution68 implements Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[] sizes = new int[n];
        for (int i = 0; i < n; i++) {
            sizes[i] = words[i].length();
        }
        List<String> res = new ArrayList<>();
        int s = 0, t = 1, width = sizes[s];
        while (t < n) {
            int blanks = t - s;
            if (width + blanks + sizes[t] <= maxWidth) {
                width += sizes[t];
                t++;
                continue;
            }
            // words[s,t) as a line
            if (blanks > 1) {
                blanks--;
            }
            int blankWidth = (maxWidth - width) / blanks;
            int remainder = (maxWidth - width) % blanks;
            StringBuilder line = new StringBuilder(maxWidth);
            for (int i = 0; i < remainder; i++) {
                line.append(words[s + i]);
                line.append(" ".repeat(blankWidth + 1));
            }
            for (int i = remainder; i < blanks; i++) {
                line.append(words[s + i]);
                line.append(" ".repeat(blankWidth));
            }
            // the rightmost word
            if (line.length() < maxWidth) {
                line.append(words[t - 1]);
            }
            res.add(line.toString());
            s = t++;
            width = sizes[s];
        }
        // the last line
        StringBuilder line = new StringBuilder(maxWidth);
        line.append(words[s]);
        for (int i = s + 1; i < t; i++) {
            line.append(' ').append(words[i]);
        }
        while (line.length() < maxWidth) {
            line.append(' ');
        }
        res.add(line.toString());
        return res;
    }
}
