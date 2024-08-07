package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/nim-game/">292. Nim Game</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution294
 */
@Question(
        tags = {Tag.BRAINTEASER, Tag.MATH, Tag.GAME_THEORY},
        difficulty = Difficulty.EASY
)
public class Solution292 {

    /**
     * Bash Game: given n stones, take turns to remove 1~m stones, then the person who takes the last turn wins.
     * <p>
     * If (m+1)|n, the person who takes the first turn will certainly win. Otherwise, fail.
     */
    @Complexity(time = "O(1)", space = "O(1)")
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}