package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution173;
import java.util.Iterator;

/**
 * 284. Peeking Iterator (Medium)
 *
 * @author Kingen
 * @see Solution173
 * @see Solution251
 * @see Solution281
 * @see <a href="https://leetcode-cn.com/problems/peeking-iterator/">Peeking Iterator</a>
 */
public class Solution284 implements Solution {

    static class PeekingIterator implements Iterator<Integer> {

        private final Iterator<Integer> delegate;
        private Integer next = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            delegate = iterator;
        }

        /**
         * Returns the next element in the iteration without advancing the iterator.
         */
        public Integer peek() {
            if (next == null) {
                next = delegate.next();
            }
            return next;
        }

        /**
         * hasNext() and next() should behave the same as in the Iterator interface. Override them
         * if needed.
         */
        @Override
        public Integer next() {
            if (next == null) {
                return delegate.next();
            }
            int res = next;
            next = null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return next != null || delegate.hasNext();
        }
    }
}
