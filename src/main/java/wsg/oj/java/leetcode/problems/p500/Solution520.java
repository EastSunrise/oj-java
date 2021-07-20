package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 520. Detect Capital (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/detect-capital/">Detect Capital</a>
 * @since 2021-07-20
 */
class Solution520 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 1) {
            return true;
        }
        char first = word.charAt(0);
        if (first > 'Z') {
            // all lower case
            for (int i = 1; i < len; i++) {
                if (word.charAt(i) < 'a') {
                    return false;
                }
            }
            return true;
        }
        boolean upper = word.charAt(1) < 'a';
        for (int i = 2; i < len; i++) {
            if ((word.charAt(i) < 'a') ^ upper) {
                return false;
            }
        }
        return true;
    }
}
