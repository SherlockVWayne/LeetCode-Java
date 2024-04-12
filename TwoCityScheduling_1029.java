package LeetCode;

import java.util.Arrays;

public class TwoCityScheduling_1029 {
    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int diffA = Math.abs(a[0] - a[1]);
            int diffB = Math.abs(b[0] - b[1]);
            return diffB - diffA;
        });
        // Sort based on the cost diff
        // between going to A and B
        // [400, 5] -> [200, 5] -> [10, 5]
        
        int peopleInCityA = costs.length / 2;
        int peopleInCityB = costs.length / 2;
        int result = 0;
        for (int[] cost : costs) {
            if (peopleInCityA > 0 && peopleInCityB > 0) {
                if (cost[0] < cost[1]) { // City A is closer
                    result = result + cost[0];
                    peopleInCityA--;
                } else {
                    result = result + cost[1];
                    peopleInCityB--;
                }
            } else if (peopleInCityA > 0) {
                result += cost[0];
                peopleInCityA--;
            } else {
                result += cost[1];
                peopleInCityB--;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }
}
//Intuition
//To avoid picking a expensive city latter on we sort the citie cost according to diff of their cost.
//
//Approach
//Keep track of how many city A or B have been already filled
//
//
//Time complexity: O(nlogn)
//Space complexity: O(1)