package wsg.oj.java.leetcode.problems.p700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution56;

/**
 * 763. Partition Labels (MEDIUM)
 *
 * @author Kingen
 * @see Solution56
 * @see <a href="https://leetcode-cn.com/problems/partition-labels/">Partition Labels</a>
 * @since 2021-07-27
 */
public class Solution763 implements Solution {

    /**
     * @complexity T=O(n+26)
     * @complexity S=O(26)
     */
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        // lasts[i]: the last index of i+'a' in s
        int[] lasts = new int[26];
        Arrays.fill(lasts, -1);
        for (int i = 0; i < n; i++) {
            lasts[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lasts[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
