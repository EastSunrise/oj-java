package wsg.oj.java.leetcode.problems.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.StringSolution;

/**
 * 剑指 Offer 38. 字符串的排列  LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/">字符串的排列  LCOF</a>
 * @since 2021-07-28
 */
public class Offer38 implements StringSolution {

    /**
     * @see #DFS
     */
    public String[] permutation2(String s) {
        Set<String> res = new HashSet<>();
        dfs(res, s.toCharArray(), new boolean[s.length()], new char[s.length()], 0);
        return res.toArray(new String[0]);
    }

    private void dfs(Set<String> res, char[] s, boolean[] visited, char[] tmp, int t) {
        if (t == tmp.length) {
            res.add(new String(tmp));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[t] = s[i];
                dfs(res, s, visited, tmp, t + 1);
                // restore
                visited[i] = false;
            }
        }
    }

    /**
     * @see #DFS
     */
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, stat(s), new char[s.length()], '\0', 0);
        return res.toArray(new String[0]);
    }

    private void dfs(List<String> res, Map<Character, Integer> cs, char[] tmp, char prev, int i) {
        if (i == tmp.length) {
            res.add(new String(tmp));
            return;
        }
        for (Map.Entry<Character, Integer> entry : cs.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            if (ch == prev || cnt == 0) {
                continue;
            }
            for (int k = 1; k <= cnt; k++) {
                tmp[i++] = ch;
                cs.put(ch, cnt - k);
                dfs(res, cs, tmp, ch, i);
            }
            // restore
            i -= cnt;
            cs.put(ch, cnt);
        }
    }
}
