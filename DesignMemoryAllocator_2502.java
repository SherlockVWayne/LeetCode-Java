package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignMemoryAllocator_2502 {

}

class Allocator {
    int n;
    AllocatedBlockNode dummyHead;
    Map<Integer, List<AllocatedBlockNode>> idBlockMap;
    
    public Allocator(int n) {
        this.n = n;
        this.dummyHead = new AllocatedBlockNode(0, 0);
        this.idBlockMap = new HashMap<>();
    }
    
    public int allocate(int size, int mID) {
        if (size > n) {
            return -1;
        }
        
        AllocatedBlockNode prev = findPrevBlock(size);
        if (n - prev.end < size) {
            return -1;
        }
        
        AllocatedBlockNode blockNode = allocateBlock(size, prev);
        idBlockMap.computeIfAbsent(mID, k -> new ArrayList<>()).add(blockNode);
        
        return blockNode.start;
    }
    
    private AllocatedBlockNode findPrevBlock(int size) {
        AllocatedBlockNode prev = dummyHead;
        AllocatedBlockNode curr = prev.next;
        
        while (curr != null) {
            if (curr.start - prev.end >= size) {
                return prev;
            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public int freeMemory(int mID) {
        List<AllocatedBlockNode> blocks = idBlockMap.get(mID);
        if (blocks == null) {
            return 0;
        }
        
        int length = 0;
        for (AllocatedBlockNode blockNode : blocks) {
            removeBlock(blockNode);
            length += blockNode.size;
        }
        idBlockMap.remove(mID);
        return length;
    }
    
    // with proper prev, allocate size
    private AllocatedBlockNode allocateBlock(int size, AllocatedBlockNode prev) {
        AllocatedBlockNode blockNode = new AllocatedBlockNode(prev.end, size);
        blockNode.prev = prev;
        blockNode.next = prev.next;
        
        prev.next = blockNode;
        if (blockNode.next != null) {
            blockNode.next.prev = blockNode;
        }
        
        return blockNode;
    }
    
    private void removeBlock(AllocatedBlockNode node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}

class AllocatedBlockNode {
    AllocatedBlockNode prev;
    AllocatedBlockNode next;
    int start;
    int end;
    int size;
    
    public AllocatedBlockNode(int start, int size) {
        this.start = start;
        this.end = start + size;
        this.size = size;
    }
}