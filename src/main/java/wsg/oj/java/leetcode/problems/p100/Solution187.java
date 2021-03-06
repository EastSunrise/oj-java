package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 187. Repeated DNA Sequences (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/repeated-dna-sequences/">Repeated DNA
 * Sequences</a>
 * @since 2021-07-12
 */
class Solution187 implements Solution {

    /**
     * Converts a sequence of 8 bits to a 32-bit integer.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len <= 10) {
            return new ArrayList<>();
        }
        int value = 0;
        // the value of the first 9 digits
        for (int i = 0; i < 9; i++) {
            value = (value << 2) + charToQuaternary(s.charAt(i));
        }
        // key: the quaternary value of the 10-letter-long sequence
        // value: count of same values
        byte[] counts = new byte[1 << 20];
        List<String> res = new ArrayList<>();
        // (1<<(c*2-1))-1
        int mask = 0x3ffff;
        // start: the start index of the 10-letter-long sequence
        for (int start = 0, sLen = len - 10; start <= sLen; start++) {
            value = (value << 2) + charToQuaternary(s.charAt(start + 9));
            counts[value]++;
            if (counts[value] == 2) {
                // more than one
                res.add(s.substring(start, start + 10));
            }
            // remove the first digit
            value = value & mask;
        }
        return res;
    }

    private int charToQuaternary(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }
}
