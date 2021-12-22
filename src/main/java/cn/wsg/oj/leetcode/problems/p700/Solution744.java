package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 744. Find Smallest Letter Greater Than Target (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/">Find
 * Smallest Letter Greater Than Target</a>
 */
public class Solution744 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public char nextGreatestLetter(char[] letters, char target) {
        target = target == 'z' ? 'a' : (char) (target + 1);
        int i = Arrays.binarySearch(letters, target);
        if (i >= 0) {
            return target;
        }
        i = -i - 1;
        return i == letters.length ? letters[0] : letters[i];
    }
}
