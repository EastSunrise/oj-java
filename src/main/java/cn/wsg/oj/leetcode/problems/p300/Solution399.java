package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/evaluate-division/">Evaluate Division</a>
 */
class Solution399 implements Solution {

    /**
     * @see Complexity#TIME_NNN
     * @see Complexity#SPACE_NN
     * @see <a href="https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm">Floyd–Warshall
     * algorithm</a>
     */
    public double[] calcEquation(List<List<String>> equations, double[] values,
        List<List<String>> queries) {
        Map<String, Integer> indices = new HashMap<>(16);
        int size = 0;
        // use an index to represent a string
        for (List<String> equation : equations) {
            for (String str : equation) {
                if (!indices.containsKey(str)) {
                    indices.put(str, size++);
                }
            }
        }

        // dp[i][j]: the value of vi/vj
        double[][] dp = new double[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1.0;
        }
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            int ai = indices.get(equation.get(0));
            int bi = indices.get(equation.get(1));
            dp[ai][bi] = values[i];
            dp[bi][ai] = 1 / values[i];
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dp[i][k] != 0 && dp[k][j] != 0) {
                        dp[i][j] = dp[i][k] * dp[k][j];
                    }
                }
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Integer ci = indices.get(query.get(0));
            Integer di = indices.get(query.get(1));
            if (ci == null || di == null || dp[ci][di] == 0) {
                res[i] = -1;
            } else {
                res[i] = dp[ci][di];
            }
        }
        return res;
    }
}
