package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 204. Count Primes (Easy)
 *
 * @author Kingen
 * @see Solution263
 * @see Solution264
 * @see Solution279
 * @see <a href="https://leetcode-cn.com/problems/count-primes/">Count Primes</a>
 */
public class Solution204 implements Solution {

    /**
     * Sieve of Eratosthenes.
     *
     * @see <a href="https://en.wikibooks.org/wiki/Discrete_Mathematics/Sieve_of_Eratosthenes">Sieve
     * of Eratosthenes</a>
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (long j = (long) i * i; j < n; j += i) {
                    notPrimes[(int) j] = true;
                }
            }
        }
        return count;
    }
}
