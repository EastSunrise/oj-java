package cn.wsg.oj.algorithm;

import cn.wsg.oj.Complexity;

/**
 * Searches the pattern with Knuth-Morris-Pratt algorithm.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/algorithms/pattern-searching/knuth-morris-pratt-algorithm.html">Knuth-Morris-Pratt
 * Algorithm</a>
 */
public class KmpSearching implements PatternSearching {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_M
     */
    @Override
    public int search(char[] txt, char[] pat) {
        int m = pat.length;
        if (m == 0) {
            return 0;
        }
        int[] next = computeNext(pat, m);
        int i = 0, j = 0;
        while (i < txt.length && j < m) {
            if (txt[i] == pat[j]) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return j == m ? i - j : -1;
    }

    private int[] computeNext(char[] pat, int m) {
        int j = 0, k = -1;
        int[] next = new int[m];
        next[0] = -1;
        while (j < m - 1) {
            if (k == -1 || pat[j] == pat[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
