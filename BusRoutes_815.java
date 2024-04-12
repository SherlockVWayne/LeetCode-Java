package LeetCode;

import java.util.*;

public class BusRoutes_815 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (routes == null || routes.length == 0) return -1;
        if (source == target) return 0;
        
        // Step I: map to store each stop and the routes passing through it
        // key: stop
        // val: list of route indices that can reach to the stop
        Map<Integer, HashSet<Integer>> stopToRoutes = new HashMap<Integer, HashSet<Integer>>();
        for (int routeIndex = 0; routeIndex < routes.length; routeIndex++) {
            for (int stop : routes[routeIndex]) {
                stopToRoutes.putIfAbsent(stop, new HashSet<>());
                stopToRoutes.get(stop).add(routeIndex);
            }
        }
        
        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) {
            return -1;
        }
        
        // Step II.I: use queue to find all connected routes
        // [current stop, number of changes]
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{source, 0});
        
        // Step II.II: use set to store all visited
        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        
        Set<Integer> visitedRoutes = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] currentElement = queue.pollFirst();
            int currentStop = currentElement[0];
            int changes = currentElement[1];
            
            if (currentStop == target) {
                return changes;
            }
            
            // iterate over each route passing through the current stop
            for (int routeIndex : stopToRoutes.get(currentStop)) {
                if (visitedRoutes.contains(routeIndex)) {
                    continue;
                }
                
                for (int nextStop : routes[routeIndex]) {
                    if (!visitedStops.contains(nextStop)) {
                        queue.offerLast(new int[]{nextStop, changes + 1});
                        visitedStops.add(nextStop);
                    }
                }
                
                // mark the route as visited
                visitedRoutes.add(routeIndex);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {89, 12, 13}, {5, 12}}, 15, 12));
    }
}
