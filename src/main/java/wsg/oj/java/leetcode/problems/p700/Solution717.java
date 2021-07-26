package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution89;

/**
 * 717. 1-bit and 2-bit Characters (EASY)
 *
 * @author Kingen
 * @see Solution89
 * @see <a href="https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit
 * Characters</a>
 * @since 2021-07-26
 */
public class Solution717 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isOneBitCharacter(int[] bits) {
        // count the number of contiguous 1 before the last 0
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) {
            i--;
        }
        return ((bits.length - i) & 1) == 0;
    }
}
