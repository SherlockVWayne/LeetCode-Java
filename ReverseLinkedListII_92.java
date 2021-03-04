package LeetCode;

public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode currentNode = head;

        while (m > 1) {
            prev = currentNode;
            currentNode = currentNode.next;
            m--;
            n--;
        }

        ListNode connection = prev;
        ListNode tail = currentNode;

        while (n > 0) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
            n--;
        }

        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }

        tail.next = currentNode;
        return head;
    }
}
