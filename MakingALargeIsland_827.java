package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland_827 {
    
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) {
        System.out.println(new MakingALargeIsland_827().largestIsland_II(new int[][]{
            {1, 0}, {0, 1}
        }));
    }
    
    public int largestIsland_II(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int graphIndex = 2;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j, visited, graphIndex);
                    if (area == grid.length * grid[0].length) {
                        return area;
                    }
                    map.put(graphIndex, area);
                    graphIndex++;
                }
            }
        }
        
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int newArea = 0;
                    Set<Integer> graphSet = new HashSet<>();
                    for (int[] dir : dirs) {
                        int[] newPosition = new int[]{i + dir[0], j + dir[1]};
                        if (isInRange(grid, newPosition[0], newPosition[1]) && grid[newPosition[0]][newPosition[1]] != 1) {
                            graphSet.add(grid[newPosition[0]][newPosition[1]]);
                        }
                    }
                    for (int graph : graphSet) {
                        newArea += map.getOrDefault(graph, 0);
                    }
                    maxArea = Math.max(maxArea, 1 + newArea);
                }
            }
        }
        return maxArea;
    }
    
    private boolean isInRange(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    
    private int bfs(int[][] grid, int i, int j, boolean[][] visited, int graphIndex) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        grid[i][j] = graphIndex;
        int area = 0;
        for (int[] dir : dirs) {
            area += bfs(grid, i + dir[0], j + dir[1], visited, graphIndex);
        }
        return area + 1;
    }
    
    private boolean isInRange(int[] position, int m, int n) {
        return position[0] < m && position[0] >= 0 && position[1] >= 0 && position[1] < n;
    }
    
    private int convertCoordinate(int[] position, int n) {
        return position[0] * n + position[1];
    }

//    public int largestIsland(int[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//
//        int[] ufArray = new int[grid.length * grid[0].length];
//        int maxArea = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//
//            }
//        }
//    }
}

class WeightedUnionFind {
    int[] root;
    int[] weight;
    
    public WeightedUnionFind(int n) {
        this.root = new int[n];
        this.weight = new int[n];
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if (weight[rootP] > weight[rootQ]) {
            root[rootQ] = rootP;
            weight[rootQ] += weight[rootP];
        } else {
            root[rootP] = rootQ;
            weight[rootP] += weight[rootQ];
        }
    }
    
    public int find(int p) {
        return root[p];
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    
}
