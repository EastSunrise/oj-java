package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/validate-ip-address/">468. Validate IP Address</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution751
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2299
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution468 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String validIPAddress(String ip) {
        if (ip.indexOf('.') >= 0) {
            return isValidIPv4(ip) ? "IPv4" : "Neither";
        }
        return isValidIPv6(ip) ? "IPv6" : "Neither";
    }

    private boolean isValidIPv4(String ip) {
        int count = 0, i = 0, n = ip.length();
        while (i < n && count < 4) {
            int j = ip.indexOf('.', i);
            if (j < 0) {
                j = n;
            }
            if (!isValidIPv4Part(ip, i, j)) {
                return false;
            }
            i = j + 1;
            count++;
        }
        return i == n + 1 && count == 4;
    }

    private boolean isValidIPv4Part(String ip, int i, int j) {
        if (i >= j || j - i > 3) {
            return false;
        }
        int num = ip.charAt(i) - '0';
        if ((num < 0 || num > 9) || (num == 0 && i + 1 < j)) { // not a number or a leading zero
            return false;
        }
        while (++i < j) {
            char ch = ip.charAt(i);
            if (ch < '0' || ch > '9') { // not a number
                return false;
            }
            num = num * 10 + (ch - '0');
        }
        return num <= 255;
    }

    private boolean isValidIPv6(String ip) {
        int count = 0, i = 0, n = ip.length();
        while (i < n && count < 8) {
            int j = ip.indexOf(':', i);
            if (j < 0) {
                j = n;
            }
            if (!isValidIPv6Part(ip, i, j)) {
                return false;
            }
            i = j + 1;
            count++;
        }
        return i == n + 1 && count == 8;
    }

    private boolean isValidIPv6Part(String ip, int i, int j) {
        if (i >= j || j - i > 4) {
            return false;
        }
        for (; i < j; i++) {
            char ch = ip.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f')) {
                continue;
            }
            return false;
        }
        return true;
    }
}