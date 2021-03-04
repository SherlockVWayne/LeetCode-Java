package LeetCode;

public class DesignTicTacToe_348 {
    class TicTacToe {

        private int[] rows;
        private int[] columns;
        private int diagnalSum;
        private int antiDiagnalSum;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            rows = new int[n];
            columns = new int[n];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int playerValue = (player == 1) ? 1 : -1;

            if (row == col) {
                diagnalSum += playerValue;
            }

            if (col == (columns.length - 1 - row)) {
                antiDiagnalSum += playerValue;
            }

            rows[row] += playerValue;
            columns[col] += playerValue;

            int size = rows.length;

            if (Math.abs(diagnalSum) == size ||
                    Math.abs(antiDiagnalSum) == size ||
                    Math.abs(rows[row]) == size ||
                    Math.abs(columns[col]) == size) {
                return player;
            }
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
