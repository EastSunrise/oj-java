package wsg.oj.java.leetcode.problems.old;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kingen
 */
public class HashSolution {

    // 438. 找到字符串中所有字母异位词
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int len = p.length();

        int[] pCounts = new int[26];
        for (char c : p.toCharArray()) {
            pCounts[c - 'a']++;
        }
        int[] sCounts = new int[26];
        for (int i = 0; i < len; i++) {
            sCounts[s.charAt(i) - 'a']++;
        }

        int index = 0;
        while (true) {
            boolean isEqual = true;
            for (int i = 0; i < 26; i++) {
                if (pCounts[i] != sCounts[i]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                list.add(index);
            }
            if (index + len >= s.length()) {
                break;
            }
            sCounts[s.charAt(index) - 'a']--;
            sCounts[s.charAt(index + len) - 'a']++;
            index++;
        }
        return list;
    }
}
