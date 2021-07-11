package wsg.oj.java.leetcode.problems.base;

import java.util.function.BiFunction;
import wsg.oj.java.Complexity;

/**
 * Supplies some common tags.
 *
 * @author Kingen
 * @since 2021/6/24
 */
public interface Solution extends Complexity {

    String TO_OPTIMIZE = "To Optimize";

    /**
     * @see <a href="https://leetcode-cn.com/tag/backtracking/problemset/">Backtracking</a>
     */
    String BACKTRACKING = "Backtracking";
    String DYNAMIC_PROGRAMMING = "Dynamic Programming";
    String DFS = "Depth-First Search";
    String BFS = "Breadth-First Search";
    String BINARY_SEARCH = "Binary Search";
    String PREORDER = "Preorder";
    String INORDER = "Inorder";
    String POSTORDER = "Postorder";
    String LEVEL_ORDER = "Level Order";
    String HASHTABLE = "Hash Table";

    default int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    /**
     * Accumulates a sorted array with duplicate numbers to an array only with distinct numbers
     * in-place.
     *
     * @param counts record count of each distinct number
     * @return the length of distinct numbers
     */
    default int accumulate(int[] nums, int[] counts) {
        int current = nums[0], count = 1, len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current) {
                count++;
            } else {
                nums[len] = current;
                counts[len] = count;
                current = nums[i];
                count = 1;
                len++;
            }
        }
        nums[len] = current;
        counts[len] = count;
        len++;
        return len;
    }

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_MN
     */
    default int dp(int[][] matrix, int dp00, BiFunction<Integer, Integer, Integer> side,
        TriFunction<Integer, Integer, Integer, Integer> inside) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = dp00;
        for (int i = 1; i < m; i++) {
            dp[i][0] = side.apply(dp[i - 1][0], matrix[i][0]);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = side.apply(dp[0][j - 1], matrix[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = inside.apply(dp[i - 1][j], dp[i][j - 1], matrix[0][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    interface TriFunction<T, U, V, R> {

        R apply(T t, U u, V v);
    }
}
