package LeetCode;

import java.util.LinkedList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class N_aryTreePostorderTraversal_590 {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return result;
    }
}
