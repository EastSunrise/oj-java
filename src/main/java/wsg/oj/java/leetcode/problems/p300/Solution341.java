package wsg.oj.java.leetcode.problems.p300;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wsg.oj.java.leetcode.problems.Solution;
import wsg.oj.java.leetcode.problems.base.NestedInteger;

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
public class Solution341 extends Solution {

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
