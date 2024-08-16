package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/snake-in-matrix/">3248. Snake in Matrix</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.EASY
)
public class Solution3248 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String command : commands) {
            switch (command.charAt(0)) {
                case 'U' -> i--;
                case 'D' -> i++;
                case 'L' -> j--;
                case 'R' -> j++;
            }
        }
        return i * n + j;
    }
}