package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {
    private Map<String, LinkedList<Long>> requestMap;
    
    public RateLimiter() {
        this.requestMap = new HashMap<>();
    }
    
    public boolean rateLimit(String key, int intervalInSec, int maxLimit) {
        long currentTime = System.currentTimeMillis();
        long windowStartTime = currentTime - intervalInSec * 1000L;
        
        requestMap.putIfAbsent(key, new LinkedList<>());
        
        LinkedList<Long> timestampsStack = requestMap.get(key);
        
        // remove old request
        while (!timestampsStack.isEmpty()
            && timestampsStack.peekLast() < windowStartTime) {
            timestampsStack.pollLast();
        }
        
        // check number of requests in current window
        if (timestampsStack.size() < maxLimit) {
            timestampsStack.offerLast(currentTime);
            return true;
        } else {
            // exceed limit numbers
            return false;
        }
    }
}
