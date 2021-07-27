package wsg.oj.java;

/**
 * Constants of complexity.
 *
 * @author Kingen
 * @since 2021/7/10
 */
public interface Complexity {

    /**
     * Complexities of time.
     */
    String TIME_CONSTANT = "T=O(1)";
    String TIME_LOG_N = "T=O(log{n})";
    String TIME_H = "T=O(h)";
    String TIME_N = "T=O(n)";
    String TIME_M_PLUS_N = "T=O(m+n)";
    String TIME_N_LOG_N = "T=O(n*log{n})";
    String TIME_M_LOG_N = "T=O(m*log{n})";
    String TIME_NN = "T=O(n^2)";
    String TIME_MN = "T=O(mn)";
    String TIME_NNN = "T=O(n^3)";
    String TIME_2_N = "T=O(2^n)";
    String TIME_NF = "T=O(n!)";

    /**
     * Complexities of space.
     */
    String SPACE_CONSTANT = "S=O(1)";
    String SPACE_LOG_N = "S=O(log{n})";
    String SPACE_H = "S=O(h)";
    String SPACE_N = "S=O(n)";
    String SPACE_M = "S=O(m)";
    String SPACE_M_PLUS_N = "S=O(m+n)";
    String SPACE_N_LOG_N = "S=O(n*log{n})";
    String SPACE_M_LOG_N = "S=O(m*log{n})";
    String SPACE_NN = "S=O(n^2)";
    String SPACE_MN = "S=O(mn)";
    String SPACE_NNN = "S=O(n^3)";
    String SPACE_2_N = "S=O(2^n)";
    String SPACE_NF = "S=O(n!)";
}
