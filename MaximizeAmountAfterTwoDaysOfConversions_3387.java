package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximizeAmountAfterTwoDaysOfConversions_3387 {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> dpMap = new HashMap<>();
        
        dpMap.put(initialCurrency, 1.0);
        // key: currency
        // val: max value can get from currency
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < pairs1.size(); j++) {
                String currA = pairs1.get(j).get(0);
                String currB = pairs1.get(j).get(1);
                
                dpMap.put(currB, Math.max(
                    dpMap.getOrDefault(currB, 0.0), // current max of currency B
                    dpMap.getOrDefault(currA, 0.0) * rates1[j]) // the amount from currA to currB
                );
                dpMap.put(currA, Math.max(dpMap.getOrDefault(currA, 0.0), dpMap.getOrDefault(currB, 0.0) / rates1[j]));
            }
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < pairs2.size(); j++) {
                String currA = pairs2.get(j).get(0);
                String currB = pairs2.get(j).get(1);
                
                dpMap.put(currB, Math.max(dpMap.getOrDefault(currB, 0.0), dpMap.getOrDefault(currA, 0.0) * rates2[j]));
                dpMap.put(currA, Math.max(dpMap.getOrDefault(currA, 0.0), dpMap.getOrDefault(currB, 0.0) / rates2[j]));
            }
        }
        
        return dpMap.get(initialCurrency);
    }
}
