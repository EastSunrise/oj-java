package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-primes/">204. Count Primes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution263
 * @see cn.kingen.oj.leetcode.problem.p200.Solution264
 * @see cn.kingen.oj.leetcode.problem.p200.Solution279
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.ENUMERATION, Tag.NUMBER_THEORY},
        difficulty = Difficulty.MEDIUM
)
public class Solution204 {

    /**
     * Refers to <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of Eratosthenes</a>
     */
    @Complexity(time = "O(n log log n)", space = "O(n)")
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                ans++;
                for (long j = (long) i * i; j < n; j += i) {
                    notPrimes[(int) j] = true;
                }
            }
        }
        return ans;
    }

    /**
     * Refers to <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Euler's_sieve">Sieve of Euler</a>
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public int countPrimes_2(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                primes.add(i);
            }
            for (int p : primes) {
                int x;
                if ((x = p * i) >= n) {
                    break;
                } else {
                    notPrimes[x] = true;
                    if (i % p == 0) {
                        break;
                    }
                }
            }
        }
        return primes.size();
    }
}