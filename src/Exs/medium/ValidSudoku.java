package Exs.medium;

import Exs.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wy
 * @date 2021/9/16 18:35
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        short[] lines = new short[9];
        short[] columns = new short[9];
        short[] nines = new short[9];

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == '.')
                    continue;
                int shift = board[i][k] - '0';
                int x = i / 3 * 3 + k / 3;
                if ( ( (lines[i] | columns[k] | nines[x]) >> shift & 1 ) == 1) return false;
                nines[x] |= 1 << shift;
                lines[i] |= 1 << shift;
                columns[k] |= 1 << shift;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        boolean validSudoku = v.isValidSudoku(new char[][]{{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}});
        System.out.println(validSudoku);
    }
}
