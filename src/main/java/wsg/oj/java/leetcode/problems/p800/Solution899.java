package wsg.oj.java.leetcode.problems.p800;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 899. Orderly Queue (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/orderly-queue/">Orderly Queue</a>
 * @since 2021-07-27
 */
public class Solution899 implements Solution {

    /**
     * @complexity if k=1, T=O(n*n), otherwise, T=O(n*log{n})
     * @complexity T=O(n)
     */
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        int n = s.length();
        char[] chars = (s + s).toCharArray();
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (compare(chars, i, min, n) < 0) {
                min = i;
            }
        }
        return s.substring(min) + s.substring(0, min);
    }

    private int compare(char[] chars, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            int comp = Character.compare(chars[i + k], chars[j + k]);
            if (comp != 0) {
                return comp;
            }
        }
        return 0;
    }
}
