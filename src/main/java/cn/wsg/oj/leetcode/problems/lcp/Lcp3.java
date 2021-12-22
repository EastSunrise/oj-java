package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 3. Programmable Robot (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/programmable-robot/">Programmable Robot</a>
 */
public class Lcp3 implements Solution {

    /**
     * @complexity T=O(m+n), m=the number of obstacles
     * @complexity S=O(n)
     */
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int xn = 0, yn = 0, n = command.length();
        int[][] path = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            if (command.charAt(i - 1) == 'U') {
                yn++;
            } else {
                xn++;
            }
            path[i][0] = xn;
            path[i][1] = yn;
        }
        if (!isReachable(path, x, y, xn, yn, n)) {
            return false;
        }
        for (int[] ob : obstacles) {
            if (ob[0] <= x && ob[1] <= y && isReachable(path, ob[0], ob[1], xn, yn, n)) {
                return false;
            }
        }
        return true;
    }

    private boolean isReachable(int[][] path, int x, int y, int xn, int yn, int n) {
        long sum = (long) x + y;
        long step = sum / n;
        int i = (int) (sum % n);
        return path[i][0] == x - step * xn && path[i][1] == y - step * yn;
    }
}
