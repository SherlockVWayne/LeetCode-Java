package LeetCode;

import java.util.*;

public class NextGreaterNodeInLinkedList_1019 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> nodeVals = new ArrayList();

        ListNode currentNode = head;
        while (currentNode != null) {
            nodeVals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int[] result = new int[nodeVals.size()];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < nodeVals.size(); i ++) {
            while (!stack.isEmpty() && nodeVals.get(stack.peek()) < nodeVals.get(i)) {
                result[stack.pop()] = nodeVals.get(i);
            }
            stack.push(i);
        }

        return result;
    }
}
