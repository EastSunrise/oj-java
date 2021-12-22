package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. Repeated DNA Sequences (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/repeated-dna-sequences/">Repeated DNA
 * Sequences</a>
 */
public class Solution187 implements Solution {

    /**
     * Converts a sequence of 8 bits to a 32-bit integer.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n <= 10) {
            return new ArrayList<>();
        }
        int hash = 0;
        // the hash of the first 9 digits
        for (int i = 0; i < 9; i++) {
            hash = (hash << 2) + charToQuaternary(s.charAt(i));
        }
        Map<Integer, Integer> counts = new HashMap<>();
        List<String> res = new ArrayList<>();
        // (1<<(c*2-1))-1
        int mask = 0x3ffff;
        for (int i = 9; i < n; i++) {
            hash = (hash << 2) + charToQuaternary(s.charAt(i));
            int count = counts.getOrDefault(hash, 0);
            if (count == 1) {
                // more than one
                res.add(s.substring(i - 9, i + 1));
            }
            counts.put(hash, count + 1);
            // remove the first digit
            hash = hash & mask;
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
