package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 292. Nim Game (Easy)
 *
 * @author Kingen
 * @see Solution294
 * @see <a href="https://leetcode-cn.com/problems/nim-game/">Nim Game</a>
 * @since 2021-07-13
 */
class Solution292 implements Solution {

    /**
     * Bash Game: given n stones, take turns to remove 1~m stones, then the person who takes the
     * last turn wins.
     * <i>If (m+1)|n, the person who takes the first turn will certainly win. Otherwise fail.</i>
     *
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
