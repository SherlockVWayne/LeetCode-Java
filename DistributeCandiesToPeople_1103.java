package LeetCode;

public class DistributeCandiesToPeople_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        for (int i = 0; candies > 0; ++i) {
            result[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return result;
    }
}
