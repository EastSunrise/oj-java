package cn.wsg.oj.leetcode.problems.base;

import cn.kingen.oj.leetcode.util.ArrayUtils;

import java.util.List;

/**
 * Supplies some common tags.
 * <p>
 * Use {@link cn.kingen.oj.leetcode.util} instead.
 *
 * @author Kingen
 */
@Deprecated(forRemoval = true)
public interface Solution {

    int MOD = 1_000_000_007;

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

    /**
     * Accumulates a sorted array with duplicate numbers to an array only with distinct numbers in-place.
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

    default int calculate(char operator, int operand1, int operand2) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '*' -> operand1 * operand2;
            case '-' -> operand1 - operand2;
            case '/' -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
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
        ArrayUtils.swap(nums, i, j);
    }
}
