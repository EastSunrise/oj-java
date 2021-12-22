package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 433. Minimum Genetic Mutation (Medium)
 *
 * @author Kingen
 * @see Solution127
 * @see <a href="https://leetcode-cn.com/problems/minimum-genetic-mutation/">Minimum Genetic
 * Mutation</a>
 */
public class Solution433 implements Solution {

    /**
     * Changes a character at once to get possible next vertexes in the path from start to end.
     *
     * @complexity T=O(4*8*L), L=the length of the path
     * @see #BFS
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> valid = new HashSet<>(Arrays.asList(bank));
        if (!valid.contains(end)) {
            return -1;
        }
        Set<String> starts = new HashSet<>(), ends = new HashSet<>(), visited = new HashSet<>();
        starts.add(start);
        ends.add(end);
        visited.add(start);
        return search(starts, ends, visited, valid, new char[]{'A', 'C', 'G', 'T'});
    }

    private int search(Set<String> starts, Set<String> ends, Set<String> visited, Set<String> valid,
        char[] choices) {
        if (starts.isEmpty()) {
            return -1;
        }
        if (starts.size() > ends.size()) {
            return search(ends, starts, visited, valid, choices);
        }
        Set<String> nexts = new HashSet<>();
        for (String seq : starts) {
            StringBuilder tmp = new StringBuilder(seq);
            for (int i = 0; i < 8; i++) {
                char ch = seq.charAt(i);
                for (int j = 0; j < 4; j++) {
                    if (ch == choices[j]) {
                        continue;
                    }
                    tmp.setCharAt(i, choices[j]);
                    String next = tmp.toString();
                    if (ends.contains(next)) {
                        return 1;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (valid.contains(next)) {
                        nexts.add(next);
                        visited.add(next);
                    }
                    tmp.setCharAt(i, ch);
                }
            }
        }
        int step = search(nexts, ends, visited, valid, choices);
        return step == -1 ? -1 : step + 1;
    }
}
