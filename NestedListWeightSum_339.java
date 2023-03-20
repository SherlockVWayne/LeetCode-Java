package LeetCode;


import java.util.*;


public class NestedListWeightSum_339 {
  public int depthSum(List<NestedInteger> nestedList) {
    if (nestedList == null || nestedList.size() == 0) {
      return 0;
    }
    TreeSet<Integer> set = new TreeSet<>();
    int result = 0;
    int level = 1;
    LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
    
    // queue represents elements in each level
    while (queue.size() > 0) {
      int size = queue.size();
      // size might change when doing poll operations
      for (int i = 0; i < size; i++) {
        NestedInteger element = queue.pollFirst();
        if (element.isInteger()) {
          result += element.getInteger() * level;
        } else {
          queue.addAll(element.getList());
          // add all elements into current queue
        }
      }
      
      level += 1;
    }
    return result;
  }
}
