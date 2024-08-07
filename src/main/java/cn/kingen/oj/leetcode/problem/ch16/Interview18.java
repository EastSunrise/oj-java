package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/pattern-matching-lcci/">面试题 16.18. Pattern Matching LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.BACKTRACKING, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM
)
public class Interview18 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public boolean patternMatching(String pattern, String value) {
        int m = pattern.length(), n = value.length();
        int ac = 0, bc = 0;
        for (int i = 0; i < m; i++) {
            if (pattern.charAt(i) == 'a') {
                ac++;
            } else {
                bc++;
            }
        }
        if (n == 0) {
            return ac * bc == 0;
        }
        if (ac == 0 || bc == 0) { // all a or all b
            if (n % m != 0) {
                return false;
            }
            return value.substring(0, n / m).repeat(m).equals(value);
        }
        if (n % ac == 0 && value.substring(0, n / ac).repeat(ac).equals(value)) { // b==""
            return true;
        }
        if (n % bc == 0 && value.substring(0, n / bc).repeat(bc).equals(value)) { // a==""
            return true;
        }
        for (int al = 1; al * ac < n; al++) {
            int bx;
            if ((bx = n - al * ac) % bc != 0) {
                continue;
            }
            int bl = bx / bc;
            // ac*al+bc*bl=n, al and bl are non-negative integers representing the length of a and b
            String ap = null, bp = null;
            int i = 0, j = 0;
            while (i < m) {
                if (pattern.charAt(i) == 'a') { // compare a
                    if (ap == null) {
                        ap = value.substring(j, j + al);
                    } else if (!ap.equals(value.substring(j, j + al))) {
                        break;
                    }
                    j += al;
                } else { // compare b
                    if (bp == null) {
                        bp = value.substring(j, j + bl);
                    } else if (!bp.equals(value.substring(j, j + bl))) {
                        break;
                    }
                    j += bl;
                }
                i++;
            }
            if (i == m && !Objects.equals(ap, bp)) {
                return true;
            }
        }
        return false;
    }
}