package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 468. Validate IP Address (Medium)
 *
 * @author Kingen
 * @see Solution751
 * @see <a href="https://leetcode-cn.com/problems/validate-ip-address/">Validate IP Address</a>
 */
class Solution468 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(3) if IPv4, S=O(4) if IPv6
     */
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') >= 0) {
            return validIPv4(IP) ? "IPv4" : "Neither";
        }
        return validIPv6(IP) ? "IPv6" : "Neither";
    }

    private boolean validIPv4(String ip) {
        StringBuilder digits = new StringBuilder(3);
        int count = 0;
        for (char ch : (ip + ".").toCharArray()) {
            if (ch == '.') {
                if (count == 4 || digits.length() == 0) {
                    // too many numbers or empty numbers
                    return false;
                }
                if (digits.length() > 1 && digits.charAt(0) == '0') {
                    // leading zeros
                    return false;
                }
                int value = Integer.parseInt(digits.toString());
                if (value > 255) {
                    return false;
                }
                count++;
                digits = new StringBuilder(3);
            } else if (ch >= '0' && ch <= '9') {
                if (digits.length() == 3) {
                    // oversize
                    return false;
                }
                digits.append(ch);
            } else {
                // any illegal character
                return false;
            }
        }
        return count == 4;
    }

    private boolean validIPv6(String ip) {
        StringBuilder digits = new StringBuilder(4);
        int count = 0;
        for (char ch : (ip + ":").toCharArray()) {
            if (ch == ':') {
                if (count == 8 || digits.length() == 0) {
                    // too many numbers or empty numbers
                    return false;
                }
                count++;
                digits = new StringBuilder(4);
            } else if ((ch >= '0' && ch <= '9')
                || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f')) {
                if (digits.length() == 4) {
                    // oversize
                    return false;
                }
                digits.append(ch);
            } else {
                // any illegal character
                return false;
            }
        }
        return count == 8;
    }
}
