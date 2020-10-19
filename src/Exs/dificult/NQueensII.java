package Exs.dificult;

/**
 * @author Wei
 * @date 2020/10/17 16:02
 * 52. N皇后 II
 */
public class NQueensII {
    int res = 0;
    boolean[][] board;
    public int totalNQueens(int n) {
        if (n == 0)
            return 0;

        board = new boolean[n][n];
        putQueen(0);
        return res;
    }

    private void putQueen(int l) {
        if (l == board.length) {
            res++;
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (isValid(l,c)){
                board[l][c] = true;
                putQueen(l + 1);
                board[l][c] = false;
            }
        }

    }
    private boolean isValid(int rowIndex, int colIndex){
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex]) return false;
        }

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j
                >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        for (int i = rowIndex - 1,j = colIndex + 1; i >= 0 && j
                < board.length; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }
}
