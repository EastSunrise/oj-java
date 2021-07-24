package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 638. Shopping Offers (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shopping-offers/">Shopping Offers</a>
 * @since 2021-07-23
 */
class Solution638 implements Solution {

    /**
     * @see #DFS
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special,
        List<Integer> needs) {
        return calculate(price, special, needs, new HashMap<>());
    }

    private int calculate(List<Integer> price, List<List<Integer>> special,
        List<Integer> needs, Map<List<Integer>, Integer> visited) {
        if (visited.containsKey(needs)) {
            return visited.get(needs);
        }
        int cost = 0;
        // without any special offer
        for (int i = 0; i < needs.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }
        // use special offers
        for (List<Integer> sp : special) {
            List<Integer> nextNeeds = new ArrayList<>(needs);
            int i = 0;
            while (i < needs.size()) {
                int need = nextNeeds.get(i) - sp.get(i);
                if (need < 0) {
                    break;
                }
                nextNeeds.set(i, need);
                i++;
            }
            if (i < needs.size()) {
                // the special offer exceeds the needs
                continue;
            }
            cost = Math.min(cost, sp.get(i) + calculate(price, special, nextNeeds, visited));
        }
        visited.put(needs, cost);
        return cost;
    }
}
