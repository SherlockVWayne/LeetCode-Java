package LeetCode;

public class FlattenAMultilevelDoublyLinkedList_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        // Put pointer at head
        Node pointer = head;
        
        while (pointer != null) {
            /*CASE I: No child, proceed*/
            if (pointer.child == null) {
                pointer = pointer.next;
                continue;
            }
            /*CASE II: Has child, find tail*/
            Node temp = pointer.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            // now temp is the tail
            // Connect tail with p.next, if it is not null
            temp.next = pointer.next;
            
            if (pointer.next != null) {
                pointer.next.prev = temp;
            }
            
            // Connect p with p.child, and remove p.child
            pointer.next = pointer.child;
            pointer.child.prev = pointer;
            
            pointer.child = null;
        }
        return head;
    }
}

// Start form the head , move one step each time to the next node
// When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with p.next, by doing this we merged the child chain back to the main thread
// Return to p and proceed until find next node with child.
// Repeat until reach null