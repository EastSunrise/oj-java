package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 332. Reconstruct Itinerary (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reconstruct-itinerary/">Reconstruct Itinerary</a>
 */
public class Solution332 implements Solution {

    /**
     * The Euler paths of the graph.
     *
     * @complexity T=O(m*log m), m=|E|
     * @complexity S=O(|V|+m)
     * @see #DFS
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> edges = new HashMap<>(16);
        for (List<String> ticket : tickets) {
            List<String> tos = edges.computeIfAbsent(ticket.get(0), k -> new ArrayList<>(4));
            tos.add(ticket.get(1));
        }
        for (List<String> tos : edges.values()) {
            tos.sort(String::compareTo);
        }
        List<String> path = new ArrayList<>(300);
        findItinerary(edges, path, tickets.size() + 1, "JFK");
        return path;
    }

    private boolean findItinerary(Map<String, List<String>> edges, List<String> path, int size,
        String from) {
        path.add(from);
        if (path.size() == size) {
            return true;
        }
        List<String> tos = edges.get(from);
        if (tos != null) {
            for (int i = 0; i < tos.size(); i++) {
                String to = tos.get(i);
                if (to != null) {
                    tos.set(i, null);
                    if (findItinerary(edges, path, size, to)) {
                        return true;
                    }
                    tos.set(i, to);
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}
