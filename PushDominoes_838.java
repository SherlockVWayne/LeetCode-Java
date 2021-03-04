package LeetCode;

public class PushDominoes_838 {
    public String pushDominoes(String dominoes) {
        char[] dominoesArray = dominoes.toCharArray();
        int N = dominoesArray.length;
        int[] forces = new int[N];

        int force = 0;
        for (int i = 0; i < N; i ++) {
            if (dominoesArray[i] == 'R') {
                force = N;
            } else if (dominoesArray[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        for (int i = N -1; i >= 0; i --) {
            if (dominoesArray[i] == 'L') {
                force = N;
            } else if (dominoesArray[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i ++) {
            if (forces[i] > 0) {
                result.append('R');
            } else if (forces[i] < 0) {
                result.append('L');
            } else {
                result.append('.');
            }
        }

        return result.toString();
    }
}
