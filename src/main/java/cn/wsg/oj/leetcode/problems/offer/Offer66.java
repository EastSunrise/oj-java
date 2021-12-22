package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 66. 构建乘积数组 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/">构建乘积数组 LCOF</a>
 */
public class Offer66 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] products = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            products[i] = product;
            product *= a[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            products[i] *= product;
            product *= a[i];
        }
        return products;
    }
}
