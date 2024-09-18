package LeetCode;

public class FindNearestPointThatHasTheSameXOrYCoordinate_1779 {
    public static void main(String[] args) {
        System.out.println(new FindNearestPointThatHasTheSameXOrYCoordinate_1779().nearestValidPoint(
            3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}
        ));
    }
    
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1;
        int manhattanDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                if (x == point[0]) {
                    if (manhattanDistance > Math.abs(point[1] - y)) {
                        manhattanDistance = Math.abs(point[1] - y);
                        result = i;
                    }
                } else {
                    if (manhattanDistance > Math.abs(point[0] - x)) {
                        manhattanDistance = Math.abs(point[0] - x);
                        result = i;
                    }
                }
            }
        }
        return result;
    }
}
