package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/cat-and-mouse/">913. Cat and Mouse</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1728

 */
@Question(
        tags = {Tag.GRAPH, Tag.TOPOLOGICAL_SORT, Tag.MEMOIZATION, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.GAME_THEORY},
        difficulty = Difficulty.HARD,
        daily = "2025-02-10"
)
public class Solution913 {

    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    private static final int MOUSE_TURN = 0;
    private static final int CAT_TURN = 1;

    @Complexity(time = "O(n^3)", space = "O(n^2)")
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] results = new int[n][n][2];
        int[][][] degrees = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                degrees[i][j][MOUSE_TURN] = graph[i].length;
                degrees[i][j][CAT_TURN] = graph[j].length;
            }
        }
        for (int j : graph[0]) { // cat cannot go to 0
            for (int i = 0; i < n; i++) {
                degrees[i][j][CAT_TURN]--;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int j = 1; j < n; j++) { // mouse wins with mouse at 0 and cat at j
            results[0][j][MOUSE_TURN] = MOUSE_WIN;
            results[0][j][CAT_TURN] = MOUSE_WIN;
            queue.offer(new int[]{0, j, MOUSE_TURN});
            queue.offer(new int[]{0, j, CAT_TURN});
        }
        for (int i = 1; i < n; i++) { // cat wins with mouse at i and cat at i
            results[i][i][MOUSE_TURN] = CAT_WIN;
            results[i][i][CAT_TURN] = CAT_WIN;
            queue.offer(new int[]{i, i, MOUSE_TURN});
            queue.offer(new int[]{i, i, CAT_TURN});
        }

        while (!queue.isEmpty()) {
            int[] state = queue.remove();
            int mouse = state[0], cat = state[1], turn = state[2];
            int result = results[mouse][cat][turn];
            int prevTurn = turn == MOUSE_TURN ? CAT_TURN : MOUSE_TURN;

            if (prevTurn == MOUSE_TURN) { // mouse turn
                for (int prevMouse : graph[mouse]) {
                    if (predictResult(results, degrees, prevMouse, cat, prevTurn, result)) {
                        queue.offer(new int[]{prevMouse, cat, prevTurn});
                    }
                }
            } else {
                for (int prevCat : graph[cat]) {
                    if (prevCat != 0) {
                        if (predictResult(results, degrees, mouse, prevCat, prevTurn, result)) {
                            queue.offer(new int[]{mouse, prevCat, prevTurn});
                        }
                    }
                }
            }
        }
        return results[1][2][MOUSE_TURN];
    }

    private boolean predictResult(int[][][] results, int[][][] degrees, int mouse, int cat, int turn, int nextResult) {
        if (results[mouse][cat][turn] == 0) { // unknown
            boolean canWin = (turn == MOUSE_TURN && nextResult == MOUSE_WIN) || (turn == CAT_TURN && nextResult == CAT_WIN);
            if (canWin) { // mouse turn to win or cat turn to win
                results[mouse][cat][turn] = nextResult;
                return true;
            } else { // remove a path where the other win
                degrees[mouse][cat][turn]--;
                if (degrees[mouse][cat][turn] == 0) {
                    results[mouse][cat][turn] = nextResult;
                    return true;
                }
            }
        }
        return false;
    }
}