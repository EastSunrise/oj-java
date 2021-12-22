package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution45;
import cn.wsg.oj.leetcode.problems.p0.Solution55;

/**
 * 1306. Jump Game III (MEDIUM)
 *
 * @author Kingen
 * @see Solution45
 * @see Solution55
 * @see Solution1871
 * @see <a href="https://leetcode-cn.com/problems/jump-game-iii/">Jump Game III</a>
 */
public class Solution1306 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    private boolean dfs(int[] arr, int i) {
        if (i < 0 || i >= arr.length || arr[i] < 0) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        arr[i] = -arr[i];
        return dfs(arr, i + arr[i]) || dfs(arr, i - arr[i]);
    }
}
