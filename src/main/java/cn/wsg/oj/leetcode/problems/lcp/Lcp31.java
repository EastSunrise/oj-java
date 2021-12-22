package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.List;

/**
 * LCP 31. 变换的迷宫 (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/Db3wC1/">变换的迷宫</a>
 */
public class Lcp31 implements Solution {

    public boolean escapeMaze(List<List<String>> maze) {
        int t = maze.size(), m = maze.get(0).size(), n = maze.get(0).get(0).length();
        // -1: not visited,
        // 0bxy: the temporary scroll is used if x=1; the
        int[][][] dp = new int[m][n][t];
        return false;
    }
}
