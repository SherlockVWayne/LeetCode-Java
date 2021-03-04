package LeetCode;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // head of first half
        ListNode l1 = head;
        // tail of first half
        ListNode prev = null;

        // head of second half
        ListNode slow = head;
        // tail of second half
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l2 = reverse(slow);

        merge(l1, l2);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }

        return prev;
    }

    public void merge (ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;

            if (l1Next == null) {
                break;
            }

            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
