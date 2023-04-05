package LeetCode;

public class DesignHashMap_706 {
    class ListNode {
        int key, val;
        ListNode next;
        
        public ListNode(int key, int val, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    class MyHashMap {
        static final int DEFAULT_CAPACITY = 10_000;
        ListNode[] table;
        
        public MyHashMap() {
            this.table = new ListNode[DEFAULT_CAPACITY];
        }
        
        private int hash(Integer key) {
            return key.hashCode() % DEFAULT_CAPACITY;
        }
        
        public void put(int key, int val) {
            remove(key);
            int h = hash(key);
            ListNode node = new ListNode(key, val, table[h]);
            table[h] = node;
        }
        
        public int get(int key) {
            int h = hash(key);
            ListNode node = table[h];
            for (; node != null; node = node.next) {
                if (node.key == key) {
                    return node.val;
                }
            }
            return -1;
        }
        
        public void remove(int key) {
            int h = hash(key);
            ListNode node = table[h];
            if (node == null) return;
            if (node.key == key) {
                table[h] = node.next;
            } else {
                for (; node.next != null; node = node.next) {
                    if (node.next.key == key) {
                        node.next = node.next.next;
                        return;
                    }
                }
            }
        }
    }
}
