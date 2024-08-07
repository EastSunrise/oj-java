package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/most-common-word/">819. Most Common Word</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Solution819 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String mostCommonWord(String paragraph, String[] banned) {
        int n = paragraph.length();
        Map<String, Integer> freq = new HashMap<>(4);
        Set<String> bans = new HashSet<>(Arrays.asList(banned));
        int maxCount = 0;
        String ans = null;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                char ch = paragraph.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    builder.append((char) (ch + 32));
                    continue;
                }
                if (ch >= 'a' && ch <= 'z') {
                    builder.append(ch);
                    continue;
                }
            }
            if (builder.isEmpty()) {
                continue;
            }

            String word = builder.toString();
            if (!bans.contains(word)) {
                int count = freq.getOrDefault(word, 0) + 1;
                if (count > maxCount) {
                    maxCount = count;
                    ans = word;
                }
                freq.put(word, count);
            }
            builder = new StringBuilder();
        }
        return ans;
    }
}