package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. Most Common Word (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/most-common-word/">Most Common Word</a>
 */
public class Solution819 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> counts = new HashMap<>(4);
        Set<String> bans = new HashSet<>(Arrays.asList(banned));
        int maxCount = 0;
        String res = null;
        StringBuilder builder = new StringBuilder();
        for (char ch : (paragraph + " ").toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                builder.append((char) (ch + 32));
            } else if (ch >= 'a' && ch <= 'z') {
                builder.append(ch);
            } else if (builder.length() > 0) {
                String word = builder.toString();
                if (!bans.contains(word)) {
                    int count = counts.getOrDefault(word, 0) + 1;
                    if (count > maxCount) {
                        maxCount = count;
                        res = word;
                    }
                    counts.put(word, count);
                }
                builder = new StringBuilder();
            }
        }
        return res;
    }
}
