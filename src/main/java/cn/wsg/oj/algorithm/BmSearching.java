package cn.wsg.oj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * todo Searches the pattern with Boyer-Moore algorithm.
 *
 * @author Kingen
 */
public class BmSearching implements PatternSearching {

    @Override
    public int search(char[] txt, char[] pat) {
        return 0;
    }


    private Map<Character, Integer> badChar(char[] pat) {
        Map<Character, Integer> lastIndices = new HashMap<>();
        for (int i = 0; i < pat.length; i++) {
            lastIndices.put(pat[i], i);
        }
        return lastIndices;
    }

    private int[] strongSuffix(char[] pat, int[] shift, int m) {
        int[] suffixes = new int[m];
        int s = m - 1, t = m;
        suffixes[s] = t;
        while (s > 0) {
            while (pat[s - 1] != pat[t - 1]) {
                if (shift[t] == 0) {
                    shift[t] = t - s;
                }
                t = suffixes[s];
            }
            s--;
            t--;
            suffixes[s] = t;
        }
        return suffixes;
    }

    private void preprocess_case2(int[] shift, int[] bpos,
        char[] pat, int m) {
        int i, j;
        j = bpos[0];
        for (i = 0; i <= m; i++) {
		/* set the border position of the first character
		of the pattern to all indices in array shift
		having shift[i] = 0 */
            if (shift[i] == 0) {
                shift[i] = j;
            }

		/* suffix becomes shorter than bpos[0],
		use the position of next widest border
		as value of j */
            if (i == j) {
                j = bpos[j];
            }
        }
    }
}
