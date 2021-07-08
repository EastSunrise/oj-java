package wsg.oj.java.leetcode.problems.base;

/**
 * Supplies some common tags.
 *
 * @author Kingen
 * @since 2021/6/24
 */
public class Solution {

    protected static final String TO_OPTIMIZE = "To Optimize";

    /**
     * @see <a href="https://leetcode-cn.com/tag/backtracking/problemset/">Backtracking</a>
     */
    protected static final String BACKTRACKING = "Backtracking";
    protected static final String DYNAMIC_PROGRAMMING = "Dynamic Programming";
    protected static final String DFS = "Depth-First Search";
    protected static final String BFS = "Breadth-First Search";
    protected static final String BINARY_SEARCH = "Binary Search";
    protected static final String PREORDER = "Preorder";
    protected static final String INORDER = "Inorder";
    protected static final String POSTORDER = "Postorder";
    protected static final String LEVEL_ORDER = "Level Order";
    protected static final String HASHTABLE = "Hash Table";

    protected static final String TIME_CONSTANT = "O(1)";
    protected static final String TIME_LOG_N = "O(log_n)";
    protected static final String TIME_N = "O(n)";
    protected static final String TIME_M_PLUS_N = "O(m+n)";
    protected static final String TIME_N_LOG_N = "O(n*log_n)";
    protected static final String TIME_M_LOG_N = "O(m*log_n)";
    protected static final String TIME_NN = "O(n^2)";
    protected static final String TIME_MN = "O(mn)";

    protected static final String SPACE_CONSTANT = "O(1)";
    protected static final String SPACE_LOG_N = "O(log_n)";
    protected static final String SPACE_N = "O(n)";
    protected static final String SPACE_M_PLUS_N = "O(m+n)";
    protected static final String SPACE_N_LOG_N = "O(n*log_n)";
    protected static final String SPACE_M_LOG_N = "O(m*log_n)";
    protected static final String SPACE_NN = "O(n^2)";
    protected static final String SPACE_MN = "O(mn)";

    protected static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
