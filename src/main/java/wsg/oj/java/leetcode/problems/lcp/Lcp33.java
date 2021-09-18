package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 33. 蓄水 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/o8SXZn/">蓄水</a>
 * @since 2021-07-28
 */
public class Lcp33 implements Solution {

    /**
     * @complexity T=O(n*k), k=max{vat/bucket}
     * @complexity S=O(1)
     */
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int store = 0;
        for (int i = 0; i < n; i++) {
            if (vat[i] != 0) {
                if (bucket[i] == 0) {
                    store = Math.max(store, vat[i]);
                } else {
                    store = Math.max(store, (vat[i] - 1) / bucket[i] + 1);
                }
            }
        }
        if (store == 0) {
            return 0;
        }
        int ops = Integer.MAX_VALUE;
        for (int i = 1; i <= store; i++) {
            int cnt = i;
            for (int j = 0; j < n; j++) {
                cnt += Math.max(0, (vat[j] - 1) / i + 1 - bucket[j]);
            }
            ops = Math.min(ops, cnt);
        }
        return ops;
    }
}
