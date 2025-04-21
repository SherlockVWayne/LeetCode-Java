package LeetCode;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter_ReentrantLock {
    private Map<String, LinkedList<Long>> requestMap;
    private Map<String, Lock> lockMap;
    
    // ConcurrentHashMap allows multiple threads to access diff keys at the same time
    public RateLimiter_ReentrantLock() {
        this.requestMap = new ConcurrentHashMap<>();
        this.lockMap = new ConcurrentHashMap<>();
    }
    
    public boolean rateLimit(String key, int intervalInSec, int maxLimit) {
        long currentTime = System.currentTimeMillis();
        long windowStartTime = currentTime - intervalInSec * 1000L;
        
        requestMap.putIfAbsent(key, new LinkedList<>());
        lockMap.putIfAbsent(key, new ReentrantLock());
        
        Lock lock = lockMap.get(key);
        lock.lock(); // get lock to ensure the thread safety
        
        try {
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
            
        } finally {
            lock.unlock();
        }
    }
    
}
