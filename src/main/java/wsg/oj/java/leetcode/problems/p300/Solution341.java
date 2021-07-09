package wsg.oj.java.leetcode.problems.p300;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 341. Flatten Nested List Iterator
 *
 * @author Kingen
 * @see Solution251
 * @see Solution281
 * @see Solution385
 * @see Solution565
 * @see <a href="https://leetcode-cn.com/problems/flatten-nested-list-iterator/">Flatten Nested List
 * Iterator</a>
 * @since 2021/7/5
 */
public class Solution341 implements Solution {

    /**
     * This is the interface that allows for creating nested lists.
     *
     * @author Kingen
     * @since 2021/6/25
     */
    public interface NestedInteger {

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        boolean isInteger();

        /**
         * @return the single integer that this NestedInteger holds, if it holds a single integer.
         * Return null if this NestedInteger holds a nested list
         */
        Integer getInteger();

        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list. Return
         * empty list if this NestedInteger holds a single integer
         */
        List<NestedInteger> getList();
    }

    public static class NestedIterator implements Iterator<Integer> {

        private final Iterator<NestedInteger> iterator;
        private Iterator<Integer> first;

        public NestedIterator(List<NestedInteger> nestedList) {
            iterator = nestedList.iterator();
            first = Collections.emptyIterator();
        }

        @Override
        public boolean hasNext() {
            while (true) {
                if (first.hasNext()) {
                    return true;
                }
                if (!iterator.hasNext()) {
                    return false;
                }
                NestedInteger nestedInteger = iterator.next();
                if (nestedInteger.isInteger()) {
                    first = List.of(nestedInteger.getInteger()).iterator();
                } else {
                    first = new NestedIterator(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            while (true) {
                if (first.hasNext()) {
                    return first.next();
                }
                NestedInteger nestedInteger = iterator.next();
                if (nestedInteger.isInteger()) {
                    return nestedInteger.getInteger();
                }
                first = new NestedIterator(nestedInteger.getList());
            }
        }
    }
}
