package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/super-pow/">372. Super Pow</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution50
 */
@Question(tags = {Tag.MATH, Tag.DIVIDE_AND_CONQUER}, difficulty = Difficulty.MEDIUM)
public class Solution372 {

    /**
     * Uses extended <a href="https://en.wikipedia.org/wiki/Euler%27s_theorem">Euler's theorem</a>:
     * <li>If a and n are coprime, a^b≡a^(b%φ(n))(mod n);</li>
     * <li>If not coprime and b<φ(n), a^b≡a^b(mod n);</li>
     * <li>If not coprime and b>=φ(n), a^b≡a^(b%φ(n)+φ(n))(mod n).</li>
     * <p>
     * Besides, a^b≡(a%n)^b(mod n).
     */
    @Complexity(time = "O(#)", space = "O(1)")
    public int superPow(int a, int[] b) {
        // φ(1337)=φ(7*191)=1140
        int n = 1337, phi = 1140;
        a %= n;
        if (a == 0) {
            return 0;
        }

        int m = 0;
        for (int i = 0; i < 5 && i < b.length; i++) {
            m = m * 10 + b[i];
        }
        if (a % 7 == 0 || a % 191 == 0) { // a and n are not coprime
            if (m >= phi) {
                for (int i = 5; i < b.length; i++) {
                    m = (m * 10 + b[i]) % phi;
                }
                m += phi;
            }
        } else { // a and n are coprime
            for (int i = 5; i < b.length; i++) {
                m = (m * 10 + b[i]) % phi;
            }
        }

        int ans = 1;
        while (m-- > 0) {
            ans = (ans * a) % n;
        }
        return ans;
    }
}