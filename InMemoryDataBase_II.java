package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InMemoryDataBase_II {
    
    // 主存储，用于保存键值对
    private Map<String, String> database;
    // 用于记录每个值有多少键引用
    private Map<String, Integer> valueCount;
    // 事务存储栈，存储事务中的操作，用于回滚
    private Stack<Transaction> transactionStack;
    private boolean inTransaction;
    
    public InMemoryDataBase_II() {
        database = new HashMap<>();
        valueCount = new HashMap<>();
        transactionStack = new Stack<>();
        inTransaction = false;
    }
    
    // 测试主方法
    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();
        
        db.set("a", "10");
        db.set("b", "20");
        System.out.println(db.get("a")); // 输出: 10
        System.out.println(db.numWithValue("10")); // 输出: 1
        db.unset("a");
        System.out.println(db.get("a")); // 输出: NULL
        System.out.println(db.numWithValue("10")); // 输出: 0
        
        db.begin(); // 开启事务
        db.set("a", "30");
        System.out.println(db.get("a")); // 输出: 30
        db.rollback(); // 回滚
        System.out.println(db.get("a")); // 输出: NULL
    }
    
    // SET命令：设置变量和值
    public void set(String key, String value) {
        if (inTransaction) {
            // 保存原来的值，以便事务回滚
            transactionStack.peek().addOperation(key, database.get(key));
        }
        
        if (database.containsKey(key)) {
            decrementValueCount(database.get(key));
        }
        
        database.put(key, value);
        incrementValueCount(value);
    }
    
    // GET命令：获取键的值
    public String get(String key) {
        return database.getOrDefault(key, "NULL");
    }
    
    // UNSET命令：删除键
    public void unset(String key) {
        if (inTransaction) {
            // 保存原来的值，以便事务回滚
            transactionStack.peek().addOperation(key, database.get(key));
        }
        
        if (database.containsKey(key)) {
            decrementValueCount(database.get(key));
            database.remove(key);
        }
    }
    
    // NUMWITHVALUE命令：获取某值的键的数量
    public int numWithValue(String value) {
        return valueCount.getOrDefault(value, 0);
    }
    
    // BEGIN命令：开启事务
    public void begin() {
        if (!inTransaction) {
            inTransaction = true;
        }
        transactionStack.push(new Transaction());
    }
    
    // ROLLBACK命令：回滚事务
    public void rollback() {
        if (!inTransaction || transactionStack.isEmpty()) {
            System.out.println("NO TRANSACTION");
            return;
        }
        
        Transaction transaction = transactionStack.pop();
        
        // 将事务中的操作回滚
        for (Map.Entry<String, String> entry : transaction.getOperations().entrySet()) {
            String key = entry.getKey();
            String oldValue = entry.getValue();
            
            if (oldValue == null) {
                // 如果是unset之前的操作，删除键
                if (database.containsKey(key)) {
                    decrementValueCount(database.get(key));
                    database.remove(key);
                }
            } else {
                // 恢复旧值
                if (database.containsKey(key)) {
                    decrementValueCount(database.get(key));
                }
                database.put(key, oldValue);
                incrementValueCount(oldValue);
            }
        }
        
        // 如果没有事务块了，退出事务模式
        if (transactionStack.isEmpty()) {
            inTransaction = false;
        }
    }
    
    // 增加值的计数
    private void incrementValueCount(String value) {
        valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
    }
    
    // 减少值的计数
    private void decrementValueCount(String value) {
        valueCount.put(value, valueCount.get(value) - 1);
        if (valueCount.get(value) == 0) {
            valueCount.remove(value);
        }
    }
    
    // 事务类，用于保存事务中的操作
    private static class Transaction {
        private Map<String, String> operations;
        
        public Transaction() {
            operations = new HashMap<>();
        }
        
        public void addOperation(String key, String oldValue) {
            if (!operations.containsKey(key)) {
                operations.put(key, oldValue); // 保存事务之前的值
            }
        }
        
        public Map<String, String> getOperations() {
            return operations;
        }
    }
}
