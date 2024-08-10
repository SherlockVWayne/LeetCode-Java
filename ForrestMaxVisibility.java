package LeetCode;

public class ForrestMaxVisibility {
    
    public static int[] maxVisibilityCoordinates(char[][] forest) {
        int maxVisibility = -1;
        int[] coordinates = new int[]{-1, -1};
        
        int rows = forest.length;
        int cols = forest[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (forest[i][j] == '_') {
                    int visibility = calculateVisibility(forest, i, j);
                    if (visibility > maxVisibility) {
                        maxVisibility = visibility;
                        coordinates[0] = i;
                        coordinates[1] = j;
                    }
                }
            }
        }
        
        return coordinates;
    }
    
    public static int calculateVisibility(char[][] forest, int row, int col) {
        int visibility = 0;
        int rows = forest.length;
        int cols = forest[0].length;
        
        // Check visibility in each direction
        for (int i = row - 1; i >= 0 && forest[i][col] == '_'; i--) { // Up
            visibility++;
        }
        for (int i = row + 1; i < rows && forest[i][col] == '_'; i++) { // Down
            visibility++;
        }
        for (int j = col - 1; j >= 0 && forest[row][j] == '_'; j--) { // Left
            visibility++;
        }
        for (int j = col + 1; j < cols && forest[row][j] == '_'; j++) { // Right
            visibility++;
        }
        
        return visibility;
    }
    
    public static void main(String[] args) {
        char[][] forest = {
            {'_', '_', '_', 'X'},
            {'_', 'X', '_', '_'},
            {'_', '_', 'X', '_'}
        };
        Print.printIntArray(maxVisibilityCoordinates_II(forest));
    }
    
    // Function to calculate maximum visibility
    public static int[] maxVisibilityCoordinates_II(char[][] forest) {
        int m = forest.length;
        int n = forest[0].length;
        
        int[][] visibility = new int[m][n];
        
        // Initialize visibility matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest[i][j] == 'X') {
                    visibility[i][j] = 0; // Trees have visibility 0
                } else {
                    visibility[i][j] = 1; // Open land has visibility 1
                }
            }
        }
        
        // Update visibility matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest[i][j] == 'X') {
                    continue; // Skip trees
                }
                // Update visibility for each direction
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    int count = 0;
                    while (x >= 0 && x < m && y >= 0 && y < n && forest[x][y] != 'X') {
                        count++;
                        x += dir[0];
                        y += dir[1];
                    }
                    visibility[i][j] = Math.max(visibility[i][j], count);
                }
            }
        }
        
        // Find the maximum visibility
        int maxVisibility = 0;
        int[] coordinates = {-1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visibility[i][j] > maxVisibility) {
                    maxVisibility = visibility[i][j];
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        
        return coordinates;
    }
    
    // Directions: Up, Down, Left, Right
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
}
