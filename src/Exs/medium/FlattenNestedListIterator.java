package Exs.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author wy
 * @date 2021/3/22 20:56
 */
//341. 扁平化嵌套列表迭代器
public class FlattenNestedListIterator {
    private interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

                //@return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
    private static class NestedIterator implements Iterator<Integer> {
        private List<Integer> list;
        private Iterator<Integer> i;
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            fill(nestedList);
            i = list.iterator();
        }

        private void fill(List<NestedInteger> nestedList){
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }else {
                    fill(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return i.next();
        }

        @Override
        public boolean hasNext() {
            return i.hasNext();
        }
    }

}
