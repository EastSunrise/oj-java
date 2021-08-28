package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 13. 机器人的运动范围  LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/">机器人的运动范围
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer13 implements Solution {

    /**
     * @see #DFS
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, visited, 0, 0);
    }

    private int dfs(int m, int n, int k, boolean[][] visited, int i, int j) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        if (digitsSum(i) + digitsSum(j) > k) {
            return 0;
        }
        int count = 1;
        count += dfs(m, n, k, visited, i + 1, j);
        count += dfs(m, n, k, visited, i, j + 1);
        return count;
    }

    private int digitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
