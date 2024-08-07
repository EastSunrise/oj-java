package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.SameAs;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/lru-cache-lcci/">面试题 16.25. LRU Cache LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DESIGN, Tag.HASH_TABLE, Tag.LINKED_LIST, Tag.DOUBLY_LINKED_LIST},
        difficulty = Difficulty.MEDIUM
)
public class LRUCache {

    @SameAs(cn.kingen.oj.leetcode.problem.p100.LRUCache.class)
    public LRUCache(int capacity) {
    }
}