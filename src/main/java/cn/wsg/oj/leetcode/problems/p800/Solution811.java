package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. Subdomain Visit Count (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/subdomain-visit-count/">Subdomain Visit Count</a>
 */
public class Solution811 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>(cpdomains.length);
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            String domain = parts[1];
            int count = Integer.parseInt(parts[0]);
            while (true) {
                int old = counts.getOrDefault(domain, 0);
                counts.put(domain, old + count);
                int idx = domain.indexOf('.');
                if (idx < 0) {
                    break;
                }
                domain = domain.substring(idx + 1);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
