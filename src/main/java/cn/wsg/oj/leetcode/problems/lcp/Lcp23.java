package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * LCP 23. 魔术排列 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/er94lq/">魔术排列</a>
 */
public class Lcp23 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] shuffle = shuffle(n, n);
        int len = 0;
        while (len < n && target[len] == shuffle[len]) {
            len++;
        }
        return len > 0 && Arrays.equals(shuffle(n, len), target);
    }

    private int[] shuffle(int n, int k) {
        int[] src = new int[n], dest = new int[n], target = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = i + 1;
        }
        int left = 0, right = n, t = 0;
        while (left < right) {
            int d = 0;
            for (int i = left + 1; i < right; i += 2) {
                dest[d++] = src[i];
            }
            for (int i = left; i < right; i += 2) {
                dest[d++] = src[i];
            }
            int max = Math.min(d, k);
            for (int i = 0; i < max; i++) {
                target[t++] = dest[i];
            }
            left = max;
            right = d;
            int[] tmp = src;
            src = dest;
            dest = tmp;
        }
        return target;
    }
}
