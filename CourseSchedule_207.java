package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_207 {
    public static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        // List<Integer>[] graph = new ArrayList[n];
        // Unchecked assignment: 'java.util.ArrayList[]' to 'java.util.List<java.lang.Integer>[]'
        int[] degree = new int[n];
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
            degree[pre[0]]++;
        }
        
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                result.add(i);
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            for (int course : graph[result.get(i)]) {
                if (--degree[course] == 0) {
                    result.add(course);
                    // degree[course]--;
                }
            }
        }
        
        return result.size() == n;
        
        // O(N + Edges)
        // N: number of classes
    }
    
    public static void main(String[] args) {
        System.out.println(canFinish(4, new int[][]{
            {1, 0}, {2, 0}, {3, 1}, {3, 2}
        }));
    }
}

// [1,0],[2,0],[3,1],[3,2]
//      i:  0   1   2   3
// degree:  0   2   1   1
// Topological sort (using in-degrees)
// Using DFS to find the in-degree of each node
// If detected a cycle:
//     Error: no topological sort exists
// Repeat:
// 1. Choose a vertex with in-degree 0
// 2. Add it to the sorted list of vertices
// 3. Remove from graph and update in-degrees End if graph is empty