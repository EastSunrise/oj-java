package wsg.oj.java.leetcode.problems.base;

import java.util.List;
import java.util.function.BiFunction;
import wsg.oj.java.Complexity;

/**
 * Supplies some common tags.
 *
 * @author Kingen
 * @since 2021/6/24
 */
public interface Solution extends Complexity {

    /**
     * @see <a href="https://leetcode-cn.com/tag/backtracking/problemset/">Backtracking</a>
     */
    String BACKTRACKING = "Backtracking";
    String DYNAMIC_PROGRAMMING = "Dynamic Programming";
    String DFS = "Depth-First Search";
    String DIVIDE_AND_CONQUER = "Divide and Conquer";
    String BFS = "Breadth-First Search";
    String BINARY_SEARCH = "Binary Search";
    String PREORDER = "Preorder";
    String INORDER = "Inorder";
    String POSTORDER = "Postorder";
    String LEVEL_ORDER = "Level Order";
    String HASHTABLE = "Hash Table";

    default int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

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

    /**
     * Checks whether a character is a letter or a digit.
     */
    default boolean isAlphanumeric(char ch) {
        return isDigit(ch) || isLetter(ch);
    }

    /**
     * Checks whether the character is a digit.
     */
    default boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    /**
     * Checks whether the character is a letter.
     */
    default boolean isLetter(char ch) {
        return ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
    }

    default int calculate(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '*':
                return operand1 * operand2;
            case '-':
                return operand1 - operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    default boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    default String toNRadix(int num, int shift, int mask) {
        if (num == 0) {
            return "0";
        }
        // 0 < shift < 5
        char[] digits = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        StringBuilder builder = new StringBuilder(32 / shift);
        while (num != 0) {
            builder.insert(0, digits[num & mask]);
            num >>>= shift;
        }
        return builder.toString();
    }

    default int[] toArray(List<Integer> list) {
        int[] res = new int[list.size()];
        int i = 0;
        for (int val : list) {
            res[i++] = val;
        }
        return res;
    }

    default void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    interface TriFunction<T, U, V, R> {

        R apply(T t, U u, V v);
    }
}
