package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands_II_305 {
    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] map = new int[m][n];
        List<Integer> result = new ArrayList<>();
        
        for (int[] position : positions) {
            map[position[0]][position[1]] = 1;
            result.add(countIslands(map));
        }
        return result;
    }
    
    private static int countIslands(int[][] map) {
        int islands = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(map, i, j, visited);
                    islands += 1;
                }
            }
        }
        return islands;
    }
    
    private static void bfs(int[][] map, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length
            || visited[i][j] || (!visited[i][j] && map[i][j] == 0)) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            bfs(map, i + dir[0], j + dir[1], visited);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
    }
    
    public static List<Integer> numIslands2_II(int m, int n, int[][] positions) {
        // need a boolean[][] to store the state of each cell in grid
        // true is island, false is water
        boolean[][] grid = new boolean[m][n];
        
        // final return list
        List<Integer> result = new ArrayList<>();
        int currIsland = 0;
        
        // int[] to store the relationship of each val from 0 to m*n
        // initially all the val are independent and size are all 1
        int[] parent = new int[m * n];
        int[] size = new int[m * n];
        for (int i = 0; i < m * n; i += 1) {
            parent[i] = i;
            size[i] = 1;
        }
        
        // iterate the positions to turning the cell
        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];
            if (grid[row][col] == true) {
                result.add(currIsland);
                continue;
            }
            // turning the island
            grid[row][col] = true;
            currIsland += 1;
            currIsland -= connectIsland(parent, size, row, col, m, n, grid);
            result.add(currIsland);
        }
        return result;
    }
    
    private static int connectIsland(int[] parent, int[] size, int row, int col, int m, int n, boolean[][] grid) {
        int totalConnect = 0;
        for (int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || grid[nRow][nCol] == false) {
                continue;
            }
            int nPos = nRow * n + nCol;
            int cPos = row * n + col;
            int nParent = findParent(parent, nPos);
            int cParent = findParent(parent, cPos);
            // connect two island
            if (nParent == cParent) {
                continue;
            }
            if (size[cParent] > size[nParent]) {
                parent[nParent] = cParent;
                size[cParent] += size[nParent];
            } else {
                parent[cParent] = nParent;
                size[nParent] += size[cParent];
            }
            totalConnect += 1;
        }
        return totalConnect;
        
    }
    
    private static int findParent(int[] parent, int k) {
        if (parent[k] == k) {
            return k;
        }
        return findParent(parent, parent[k]);
    }
    
    
    public static List<Integer> numIslands2_III(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        Set<String> visitedPositionsSet = new HashSet<>();
        int islandCount = 0;
        
        int[][] grid = new int[m][n];
        WeightUnionFind unionFind = new WeightUnionFind(m * n);
        
        for (int[] position : positions) {
            String posString = position[0] + "-" + position[1];
            if (visitedPositionsSet.contains(posString)) {
                result.add(islandCount);
                continue;
            }
            
            visitedPositionsSet.add(posString);
            grid[position[0]][position[1]] = 1;
            islandCount++;
            
            for (int[] dir : dirs) {
                int[] newPosition = new int[]{position[0] + dir[0], position[1] + dir[1]};
                if (isInRange(newPosition, m, n) // if new pos is in range
                    && grid[newPosition[0]][newPosition[1]] == 1 // if new position is connected to island
                ) {
                    // connect new pos with this direction island
                    if (!unionFind.isConnected(convertCoordinate(newPosition, n), convertCoordinate(position, n))) {
                        unionFind.union(convertCoordinate(newPosition, n), convertCoordinate(position, n));
                        islandCount--;
                    }
                }
            }
            
            result.add(islandCount);
        }
        
        return result;
    }
    
    private static boolean isInRange(int[] position, int m, int n) {
        return position[0] < m && position[0] >= 0 && position[1] >= 0 && position[1] < n;
    }
    
    private static int convertCoordinate(int[] position, int n) {
        return position[0] * n + position[1];
    }
}

class WeightUnionFind {
    private int[] parent; // parent[i]: root node of i
    private int[] size; // size[i]: number of nodes in the same level with i
    
    public WeightUnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i; // each node has its own as root
            size[i] = 1;
        }
    }
    
    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }
    
    public void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        if (iRoot == jRoot) {
            return;
        }
        if (size[iRoot] > size[jRoot]) { // smaller tree goes lower
            // too costly
            // for (int index = 0; index < parent.length; index++) {
            //     if (parent[index] == jRoot) {
            //         parent[index] = iRoot;
            //     }
            // }
            parent[jRoot] = iRoot;
            size[jRoot] += size[iRoot];
        } else {
            parent[iRoot] = jRoot;
            size[iRoot] += size[jRoot];
        }
    }
    
    public int find(int i) {
        while (i != parent[i]) { // compress path
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
// 0      1------2      3------4
// |             |      |      |
// 5------6      7      8      9
//        i: 0 1 2 3 4 5 6 7 8 9
// parent[i] 0 1 1 3 3 0 0 1 3 3
//   size[i] 3 3 3 4 4 3 3 3 4 4