package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_II_210 {
    public int[] findOrder_II(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            // Indegree - how many prerequisites for course i are needed.
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        }
        
        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return (index == numCourses) ? order : new int[0];
    }
    
    public static int[] findOrder(int n, int[][] prerequisites) {
        
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
                // 1. Choose a vertex with in-degree 0
                result.add(i);
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            for (int course : graph[result.get(i)]) {
                // 3. Remove from graph and update in-degrees
                degree[course] -= 1;
                if (degree[course] == 0) {
                    // 1. Choose a vertex with in-degree 0
                    result.add(course);
                    // 2. Add it to the sorted list of vertices
                }
            }
        }
        
        if (result.size() != n) {
            return new int[0];
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
    
    public static void main(String[] args) {
        Print.printIntArray(findOrder(5, new int[][]{
            {1, 0}, {4, 1}, {4, 0}, {4, 3}, {3, 0}, {3, 2}, {2, 0}
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
// 3. Remove from graph and update in-degrees
// End if graph is empty