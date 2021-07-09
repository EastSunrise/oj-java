package wsg.oj.java.leetcode.problems.base;

/**
 * Supplies some common tags.
 *
 * @author Kingen
 * @since 2021/6/24
 */
public interface Solution {

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

    String TIME_CONSTANT = "O(1)";
    String TIME_LOG_N = "O(log_n)";
    String TIME_N = "O(n)";
    String TIME_M_PLUS_N = "O(m+n)";
    String TIME_N_LOG_N = "O(n*log_n)";
    String TIME_M_LOG_N = "O(m*log_n)";
    String TIME_NN = "O(n^2)";
    String TIME_MN = "O(mn)";

    String SPACE_CONSTANT = "O(1)";
    String SPACE_LOG_N = "O(log_n)";
    String SPACE_N = "O(n)";
    String SPACE_M_PLUS_N = "O(m+n)";
    String SPACE_N_LOG_N = "O(n*log_n)";
    String SPACE_M_LOG_N = "O(m*log_n)";
    String SPACE_NN = "O(n^2)";
    String SPACE_MN = "O(mn)";

    default int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
