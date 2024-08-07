package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Iterator;

/**
 * <a href="https://leetcode.cn/problems/peeking-iterator/">284. Peeking Iterator</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.BSTIterator
 * @see cn.kingen.oj.leetcode.problem.p200.Solution251
 * @see cn.kingen.oj.leetcode.problem.p200.Solution281
 */
@Question(tags = {Tag.DESIGN, Tag.ARRAY, Tag.ITERATOR}, difficulty = Difficulty.MEDIUM)
public class PeekingIterator {

    private final Iterator<Integer> delegate;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.delegate = iterator;
    }

    public Integer peek() {
        if (next == null) {
            next = delegate.next();
        }
        return next;
    }

    public Integer next() {
        if (next == null) {
            return delegate.next();
        }
        int v = next;
        next = null;
        return v;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean hasNext() {
        return next != null || delegate.hasNext();
    }
}