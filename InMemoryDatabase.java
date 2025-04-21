package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    // 主存储，用于保存变量和值
    private Map<String, String> database;
    // 记录值对应变量的计数
    private Map<String, Integer> valueCount;
    // 事务存储，用于保存事务中的临时修改
    private Map<String, String> transaction;
    private boolean isTransactionActive;
    
    public InMemoryDatabase() {
        database = new HashMap<>();
        valueCount = new HashMap<>();
        transaction = new HashMap<>();
        isTransactionActive = false;
    }
    
    // 测试主方法
    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();
        
        // 测试基础命令
        db.set("a", "10");
        db.set("b", "10");
        db.set("c", "20");
        System.out.println(db.get("a")); // 输出: 10
        System.out.println(db.numWithValue("10")); // 输出: 2
        db.unset("a");
        System.out.println(db.get("a")); // 输出: NULL
        System.out.println(db.numWithValue("10")); // 输出: 1
        
        // 测试事务命令
        db.begin();
        db.set("a", "30");
        System.out.println(db.get("a")); // 输出: 30
        db.rollback();
        System.out.println(db.get("a")); // 输出: NULL
        
        db.begin();
        db.set("a", "30");
        db.commit();
        System.out.println(db.get("a")); // 输出: 30
        db.rollback(); // 输出: NO TRANSACTION
    }
    
    // SET命令：设置变量和值
    public void set(String name, String value) {
        if (isTransactionActive) {
            // 在事务中，先保存当前值，以便回滚
            if (!transaction.containsKey(name)) {
                transaction.put(name, database.get(name));
            }
        } else {
            // 更新valueCount
            if (database.containsKey(name)) {
                decrementValueCount(database.get(name));
            }
        }
        
        database.put(name, value);
        incrementValueCount(value);
    }
    
    // GET命令：获取变量值
    public String get(String name) {
        return database.getOrDefault(name, "NULL");
    }
    
    // UNSET命令：删除变量
    public void unset(String name) {
        if (database.containsKey(name)) {
            if (isTransactionActive && !transaction.containsKey(name)) {
                transaction.put(name, database.get(name));
            }
            
            String oldValue = database.remove(name);
            decrementValueCount(oldValue);
        }
    }
    
    // NUMWITHVALUE命令：查询当前设置为某值的变量个数
    public int numWithValue(String value) {
        return valueCount.getOrDefault(value, 0);
    }
    
    // BEGIN命令：开启事务
    public void begin() {
        if (isTransactionActive) {
            System.out.println("ACTIVE TRANSACTION");
        } else {
            isTransactionActive = true;
            transaction = new HashMap<>();
        }
    }
    
    // COMMIT命令：提交事务
    public void commit() {
        if (!isTransactionActive) {
            System.out.println("NO TRANSACTION");
        } else {
            transaction.clear();
            isTransactionActive = false;
        }
    }
    
    // ROLLBACK命令：回滚事务
    public void rollback() {
        if (!isTransactionActive) {
            System.out.println("NO TRANSACTION");
        } else {
            for (Map.Entry<String, String> entry : transaction.entrySet()) {
                String name = entry.getKey();
                String oldValue = entry.getValue();
                if (oldValue == null) {
                    database.remove(name);
                } else {
                    database.put(name, oldValue);
                }
            }
            transaction.clear();
            isTransactionActive = false;
        }
    }
    
    // 增加值计数
    private void incrementValueCount(String value) {
        valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
    }
    
    // 减少值计数
    private void decrementValueCount(String value) {
        if (valueCount.containsKey(value)) {
            valueCount.put(value, valueCount.get(value) - 1);
            if (valueCount.get(value) == 0) {
                valueCount.remove(value);
            }
        }
    }
}

