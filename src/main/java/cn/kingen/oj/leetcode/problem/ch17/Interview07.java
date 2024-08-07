package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/baby-names-lcci/">面试题 17.07. Baby Names LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Interview07 {

    @Complexity(time = "O(#)", space = "O(n)")
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, String> disjoint = new HashMap<>();
        for (String s : synonyms) {
            int i = s.indexOf(',');
            String a = s.substring(1, i);
            String b = s.substring(i + 1, s.length() - 1);
            String ap = findRoot(disjoint, a);
            String bp = findRoot(disjoint, b);
            int cmp = ap.compareTo(bp);
            if (cmp < 0) {
                disjoint.put(bp, ap);
            } else if (cmp > 0) {
                disjoint.put(ap, bp);
            }
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String s : names) {
            int i = s.indexOf('(');
            String x = s.substring(0, i);
            int cnt = Integer.parseInt(s.substring(i + 1, s.length() - 1));
            String xp = findRoot(disjoint, x);
            counts.merge(xp, cnt, Integer::sum);
        }

        String[] ans = new String[counts.size()];
        int i = 0;
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            ans[i++] = e.getKey() + "(" + e.getValue() + ")";
        }
        return ans;
    }

    private String findRoot(Map<String, String> disjoint, String x) {
        String p = disjoint.getOrDefault(x, x);
        if (!p.equals(x)) {
            p = findRoot(disjoint, p);
            disjoint.put(x, p);
        }
        return p;
    }
}