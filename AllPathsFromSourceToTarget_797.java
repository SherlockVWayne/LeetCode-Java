package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int currentNode = 0;
        int targetNode = graph.length - 1;
        
        currentPath.add(currentNode);
        dfs_array(graph, currentPath, result, currentNode, targetNode);
        return result;
    }
    
    private void dfs_array(int[][] graph, List<Integer> currentPath, List<List<Integer>> result, int currentNode, int targetNode) {
        if (currentNode == targetNode) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int nextNode : graph[currentNode]) {
            currentPath.add(nextNode);
            dfs_array(graph, currentPath, result, nextNode, targetNode);
            currentPath.remove(currentPath.size() - 1);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(List<List<Integer>> graph) {
        if (graph == null || graph.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int currentNode = 0;
        int targetNode = graph.size() - 1;
        
        currentPath.add(currentNode);
        dfs_list(graph, currentPath, result, currentNode, targetNode);
        return result;
    }
    
    private void dfs_list(List<List<Integer>> graph, List<Integer> currentPath, List<List<Integer>> result, int currentNode, int targetNode) {
        if (currentNode == targetNode) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int nextNode : graph.get(currentNode)) {
            currentPath.add(nextNode);
            dfs_list(graph, currentPath, result, nextNode, targetNode);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
// DFS pattern:
//
//  void dfs(conditions) {
//      if (termination_condition) {
//          end;
//      }
//      process_node;
//      dfs();
//      un_process_node;
//  }
//
