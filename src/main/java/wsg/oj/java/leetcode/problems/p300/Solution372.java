package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 372. Super Pow (Medium)
 *
 * @author Kingen
 * @see Solution50
 * @see <a href="https://leetcode-cn.com/problems/super-pow/">Super Pow</a>
 * @since 2021-07-04
 */
class Solution372 implements Solution {

    /**
     * By extended Euler's theorem:
     * <li>If gcd(a,n)=1, a^b≡a^(b%φ(n))(mod n);</li>
     * <li>If gcd(a,n)!=1 and b<φ(n), a^b≡a^b(mod n);</li>
     * <li>If gcd(a,n)!=1 and b>=φ(n), a^b≡a^(b%φ(n)+φ(n))(mod n).</li>
     * Besides, a^b≡(a%n)^b(mod n).
     *
     * @see <a href="https://en.wikipedia.org/wiki/Euler%27s_theorem">Euler's theorem</a>
     */
    public int superPow(int a, int[] digits) {
        // φ(1337)=φ(7*191)=1140
        int n = 1337, phi = 1140;
        a %= n;
        if (a == 0) {
            return 0;
        }
        int b = 0;
        for (int i = 0; i < 5 && i < digits.length; i++) {
            b = b * 10 + digits[i];
        }
        if (a % 7 == 0 || a % 191 == 0) {
            if (b >= phi) {
                for (int i = 5; i < digits.length; i++) {
                    b = (b * 10 + digits[i]) % phi;
                }
                b += phi;
            }
        } else {
            for (int i = 5; i < digits.length; i++) {
                b = (b * 10 + digits[i]) % phi;
            }
        }
        int res = 1;
        while (b-- > 0) {
            res = (res * a) % n;
        }
        return res;
    }
}
