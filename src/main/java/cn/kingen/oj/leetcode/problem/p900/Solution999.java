package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/available-captures-for-rook/">999. Available Captures for Rook</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2257
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3001
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3257
 * @see cn.kingen.oj.leetcode.problem.p3200.Solution3256

 */
@Question(
    tags = {Tag.ARRAY, Tag.MATRIX, Tag.SIMULATION},
    difficulty = Difficulty.EASY
)
public class Solution999 {

    private static final int SIZE = 8;
    private static final int[][] DIRECTIONS = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    @Complexity(time = "O(n^2)", space = "O(1)")
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 'R') {
                    continue;
                }

                int ans = 0;
                for (int[] d : DIRECTIONS) {
                    for (int x = i + d[0], y = j + d[1]; x >= 0 && x < SIZE && y >= 0 && y < SIZE;
                        x += d[0], y += d[1]) {
                        char c = board[x][y];
                        if (c == 'B') {
                            break;
                        }
                        if (c == 'p') {
                            ans++;
                            break;
                        }
                    }
                }
                return ans;
            }
        }
        return 0;
    }
}