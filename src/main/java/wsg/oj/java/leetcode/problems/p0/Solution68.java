package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 68. Text Justification (HARD)
 *
 * @author Kingen
 * @see Solution1592
 * @see <a href="https://leetcode-cn.com/problems/text-justification/">Text Justification</a>
 * @since 2021-07-19
 */
class Solution68 implements Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        int[] sizes = new int[len];
        for (int i = 0; i < len; i++) {
            sizes[i] = words[i].length();
        }
        List<String> res = new ArrayList<>();
        int start = 0, end = 1, width = sizes[start];
        while (end < len) {
            int blanks = end - start;
            if (width + blanks + sizes[end] <= maxWidth) {
                width += sizes[end];
                end++;
                continue;
            }
            // words[start,end) as a line
            if (blanks > 1) {
                blanks--;
            }
            int blankWidth = (maxWidth - width) / blanks;
            int remainder = (maxWidth - width) % blanks;
            StringBuilder line = new StringBuilder(maxWidth);
            for (int i = 0; i < remainder; i++) {
                line.append(words[start + i]);
                line.append(" ".repeat(blankWidth + 1));
            }
            for (int i = remainder; i < blanks; i++) {
                line.append(words[start + i]);
                line.append(" ".repeat(blankWidth));
            }
            // the rightmost word
            if (line.length() < maxWidth) {
                line.append(words[end - 1]);
            }
            res.add(line.toString());
            start = end;
            end = start + 1;
            width = sizes[start];
        }
        // the last line
        StringBuilder line = new StringBuilder(maxWidth);
        line.append(words[start]);
        for (int i = start + 1; i < end; i++) {
            line.append(' ').append(words[i]);
        }
        while (line.length() < maxWidth) {
            line.append(' ');
        }
        res.add(line.toString());
        return res;
    }
}
