package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum_II_364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        
        int levelSum = 0;
        int result = 0;
        
        // make given list as a queue
        LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        
        // queue represents elements in each level
        // queue.size() represents the max depth of given nestedList
        while (queue.size() > 0) {
            int size = queue.size();
            // size could change in each loop
            
            for (int i = 0; i < size; i++) {
                NestedInteger element = queue.pollFirst();
                if (element.isInteger()) {
                    levelSum += element.getInteger();
                } else {
                    queue.addAll(element.getList());
                    // add all elements into current level
                }
            }
            result += levelSum;
            // with deeper level, the more inner int will be added multiple times
        }
        
        return result;
    }
}
