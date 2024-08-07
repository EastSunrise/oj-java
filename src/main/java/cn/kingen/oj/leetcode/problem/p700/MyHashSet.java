package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-hashset/">705. Design HashSet</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.MyHashMap
 * @see cn.kingen.oj.leetcode.problem.p1200.Skiplist
 * @see cn.kingen.oj.leetcode.problem.p10000.ConsistentHashing
 */
@Question(
        tags = {Tag.DESIGN, Tag.ARRAY, Tag.HASH_TABLE, Tag.LINKED_LIST, Tag.HASH_FUNCTION},
        difficulty = Difficulty.EASY
)
public class MyHashSet {

    private final MyHashMap map;

    @Complexity(time = "#", space = "O(n)")
    public MyHashSet() {
        this.map = new MyHashMap();
    }

    public void add(int key) {
        this.map.put(key, 0);
    }

    public void remove(int key) {
        this.map.remove(key);
    }

    public boolean contains(int key) {
        return this.map.get(key) != -1;
    }
}