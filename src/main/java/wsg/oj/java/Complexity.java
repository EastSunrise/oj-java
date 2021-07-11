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
    String TIME_CONSTANT = "O(1)";
    String TIME_LOG_N = "O(log_n)";
    String TIME_N = "O(n)";
    String TIME_M_PLUS_N = "O(m+n)";
    String TIME_N_LOG_N = "O(n*log_n)";
    String TIME_M_LOG_N = "O(m*log_n)";
    String TIME_NN = "O(n^2)";
    String TIME_MN = "O(mn)";
    String TIME_NNN = "O(n^3)";
    String TIME_2_N = "O(2^n)";
    String TIME_NF = "O(n!)";

    /**
     * Complexities of space.
     */
    String SPACE_CONSTANT = "O(1)";
    String SPACE_LOG_N = "O(log_n)";
    String SPACE_H = "O(h)";
    String SPACE_N = "O(n)";
    String SPACE_M = "O(m)";
    String SPACE_M_PLUS_N = "O(m+n)";
    String SPACE_N_LOG_N = "O(n*log_n)";
    String SPACE_M_LOG_N = "O(m*log_n)";
    String SPACE_NN = "O(n^2)";
    String SPACE_MN = "O(mn)";
    String SPACE_2_N = "O(2^n)";
    String SPACE_NF = "O(n!)";
}
