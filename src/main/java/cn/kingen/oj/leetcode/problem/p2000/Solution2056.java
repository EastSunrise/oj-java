package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/number-of-valid-move-combinations-on-chessboard/">2056. Number of Valid Move Combinations On Chessboard</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING, Tag.BACKTRACKING, Tag.SIMULATION},
        difficulty = Difficulty.HARD
)
public class Solution2056 {

    private static final int SIZE = 8;
    private static final Map<Character, int[][]> DIRECTIONS = Map.of(
            'r', new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}},
            'b', new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}},
            'q', new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}
    );

    @Complexity(time = "#", space = "#")
    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;
        int[][] lines = new int[n][5];
        for (int i = 0; i < n; i++) {
            lines[i][0] = positions[i][0] - 1;
            lines[i][1] = positions[i][1] - 1;
        }
        return dfs(pieces, lines, 0);
    }

    /**
     * @param lines lines[k] = {startX, startY, dx, dy, len}
     */
    private int dfs(String[] pieces, int[][] lines, int k) {
        if (k == lines.length) {
            return 1;
        }

        int count = 0;
        int x = lines[k][0], y = lines[k][1];
        lines[k][4] = 0;
        if (check(lines, k)) {
            count += dfs(pieces, lines, k + 1);
        }

        int[][] directions = DIRECTIONS.get(pieces[k].charAt(0));
        for (int[] d : directions) { // choose a direction
            lines[k][2] = d[0];
            lines[k][3] = d[1];
            for (int t = 1; ; t++) { // time
                int i = x + d[0] * t, j = y + d[1] * t;
                if (i < 0 || i >= SIZE || j < 0 || j >= SIZE) { // out of board
                    break;
                }
                lines[k][4] = t;
                if (check(lines, k)) {
                    count += dfs(pieces, lines, k + 1);
                }
            }
        }
        return count;
    }

    private boolean check(int[][] lines, int k) {
        for (int i = 0; i < k; i++) { // check whether two lines are conflict
            int x1 = lines[i][0], y1 = lines[i][1], x2 = lines[k][0], y2 = lines[k][1];

            for (int t = 0; ; t++) {
                if (x1 == x2 && y1 == y2) {
                    return false;
                }
                if (t >= lines[i][4] && t >= lines[k][4]) { // both pieces have reached the end
                    break;
                }
                if (t < lines[i][4]) {
                    x1 += lines[i][2];
                    y1 += lines[i][3];
                }
                if (t < lines[k][4]) {
                    x2 += lines[k][2];
                    y2 += lines[k][3];
                }
            }
        }
        return true;
    }
}