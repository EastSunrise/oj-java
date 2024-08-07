package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/throne-inheritance/">1600. Throne Inheritance</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1900.LockingTree
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.DESIGN, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class ThroneInheritance {

    private final String king;
    private final Map<String, List<String>> children = new HashMap<>();
    private final Set<String> dead = new HashSet<>();

    @Complexity(time = "O(#)", space = "O(n)")
    ThroneInheritance(String kingName) {
        this.king = kingName;
        this.children.put(kingName, new LinkedList<>());
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void birth(String parentName, String childName) {
        children.get(parentName).add(childName);
        children.put(childName, new LinkedList<>());
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void death(String name) {
        dead.add(name);
    }

    @Complexity(time = "O(n)", space = "O(n)")
    List<String> getInheritanceOrder() {
        List<String> preorder = new ArrayList<>(children.size() - dead.size());
        dfs(preorder, king);
        return preorder;
    }

    private void dfs(List<String> preorder, String x) {
        if (!dead.contains(x)) {
            preorder.add(x);
        }
        for (String child : children.get(x)) {
            dfs(preorder, child);
        }
    }
}