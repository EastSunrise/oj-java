package wsg.oj.java.leetcode.problems.p900;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 937. Reorder Data in Log Files (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reorder-data-in-log-files/">Reorder Data in Log
 * Files</a>
 * @since 2021-07-27
 */
public class Solution937 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            boolean flag1 = isLetterLog(o1);
            boolean flag2 = isLetterLog(o2);
            if (flag1 && flag2) {
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                int i1 = o1.indexOf(' ') + 1;
                int i2 = o2.indexOf(' ') + 1;
                int res = Arrays.compare(chars1, i1, o1.length(), chars2, i2, o2.length());
                if (res != 0) {
                    return res;
                }
                return Arrays.compare(chars1, 0, i1, chars2, 0, i2);
            }
            return Boolean.compare(flag2, flag1);

        });
        return logs;
    }

    private boolean isLetterLog(String log) {
        return log.charAt(log.length() - 1) > '9';
    }
}
