package LeetCode;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter_ConcurrentHashMap {
    private Map<String, LinkedList<Long>> requestMap;
    
    // ConcurrentHashMap allows multiple threads to access diff keys at the same time
    public RateLimiter_ConcurrentHashMap() {
        this.requestMap = new ConcurrentHashMap<>();
    }
    
    public boolean rateLimit(String key, int intervalInSec, int maxLimit) {
        long currentTime = System.currentTimeMillis();
        long windowStartTime = currentTime - intervalInSec * 1000L;
        
        requestMap.putIfAbsent(key, new LinkedList<>());
        
        synchronized (requestMap.get(key)) {
            // ensure that for single key, get operation is thread safe
            // and all operations to this key will not be interrupted by other threads
            LinkedList<Long> timestampsStack = requestMap.get(key);
            
            while (!timestampsStack.isEmpty() &&
                timestampsStack.peekLast() - currentTime < windowStartTime) {
                timestampsStack.pollLast();
            }
            
            if (timestampsStack.size() < maxLimit) {
                timestampsStack.offerLast(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }
    
}
