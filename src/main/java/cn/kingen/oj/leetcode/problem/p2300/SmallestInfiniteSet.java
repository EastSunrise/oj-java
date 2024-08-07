package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/smallest-number-in-infinite-set/">2336. Smallest Number in Infinite Set</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution41
 */
@Question(
        tags = {Tag.DESIGN, Tag.HASH_TABLE, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class SmallestInfiniteSet {

    TreeSet<Integer> set;
    int threshold;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        threshold = 1;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public int popSmallest() {
        int smallest;
        if (set.isEmpty()) {
            smallest = threshold;
            threshold++;
        } else {
            smallest = set.removeFirst();
        }
        return smallest;
    }

    @Complexity(time = "O(log{n})", space = "O(1)")
    public void addBack(int num) {
        if (num < threshold) {
            set.add(num);
        }
    }
}