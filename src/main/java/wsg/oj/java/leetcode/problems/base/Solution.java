package wsg.oj.java.leetcode.problems.base;

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
}
