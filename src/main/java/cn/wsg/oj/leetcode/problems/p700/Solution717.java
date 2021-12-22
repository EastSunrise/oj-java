package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution89;

/**
 * 717. 1-bit and 2-bit Characters (EASY)
 *
 * @author Kingen
 * @see Solution89
 * @see <a href="https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit
 * Characters</a> 2021-07-26
 */
public class Solution717 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
