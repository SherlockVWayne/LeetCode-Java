package LeetCode;

import java.util.*;

public class MaxStack_716 {
    
    static class MaxStack {
        
        Node head;
        Node tail;
        TreeMap<Integer, List<Node>> map;
        
        public MaxStack() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.pre = head;
            map = new TreeMap<>();
        }
        
        public void push(int x) {
            Node newNode = new Node(x);
            newNode.pre = tail.pre;
            newNode.next = tail;
            tail.pre.next = newNode;
            tail.pre = newNode;
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<Node>());
            }
            map.get(x).add(newNode);
        }
        
        public int pop() {
            int value = tail.pre.val;
            removeNode(tail.pre);
            int listSize = map.get(value).size();
            map.get(value).remove(listSize - 1);
            if (listSize == 1) {
                map.remove(value);
            }
            return value;
        }
        
        public int top() {
            return tail.pre.val;
        }
        
        public int peekMax() {
            return map.lastKey();
        }
        
        public int popMax() {
            int maxVal = map.lastKey();
            int listSize = map.get(maxVal).size();
            Node node = map.get(maxVal).remove(listSize - 1);
            removeNode(node);
            if (listSize == 1) {
                map.remove(maxVal);
            }
            return maxVal;
        }
        
        private void removeNode(Node n) {
            Node preNode = n.pre;
            Node nextNode = n.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }
        
        class Node {
            Node pre;
            Node next;
            int val;
            
            public Node(int x) {
                this.val = x;
                this.pre = null;
                this.next = null;
            }
        }
    }
    
    /**
     * Your MaxStack object will be instantiated and called as such:
     * MaxStack obj = new MaxStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.peekMax();
     * int param_5 = obj.popMax();
     */
    
    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        obj.push(4);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.popMax());
    }
}
