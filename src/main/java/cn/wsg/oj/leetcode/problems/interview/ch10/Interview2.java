package cn.wsg.oj.leetcode.problems.interview.ch10;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 10.2. Group Anagrams LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/group-anagrams-lcci/">Group Anagrams LCCI</a>
 */
public class Interview2 implements Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            res.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
