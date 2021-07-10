package wsg.oj.java.algorithm;

import wsg.oj.java.Complexity;

/**
 * @author Kingen
 * @since 2021/7/10
 */
public class PatternSearching {

    /**
     * @param pat length>=1
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
     */
    public int bruteForce(char[] txt, char[] pat) {
        int m = pat.length;
        int imax = (txt.length - m);
        for (int i = 0; i <= imax; i++) {
            // compare txt[i,i+m) with pat
            int j = 0;
            while (j < m && txt[i + j] == pat[j]) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_M
     * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/algorithms/pattern-searching/knuth-morris-pratt-algorithm.html">Knuth-Morris-Pratt
     * Algorithm</a>
     */
    public int kmpSearch(char[] txt, char[] pat) {
        int[] next = computeNext(pat);
        int pLen = pat.length;
        int i = 0, j = 0;
        while (i < txt.length && j < pLen) {
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
        return j == pLen ? i - j : -1;
    }

    private int[] computeNext(char[] pat) {
        int j = 0, k = -1, len = pat.length;
        int[] next = new int[len];
        next[0] = -1;
        while (j < len - 1) {
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
