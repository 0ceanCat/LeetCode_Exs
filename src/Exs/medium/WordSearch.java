package Exs.medium;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wei
 * @date 2020/9/13 10:19
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 */
public class WordSearch {
    int totalRow, totalColumn, len;
    int[][] next = {{0,-1},{0,1},{1,0},{-1,0}};
    boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        if (word == null || board == null)
            return false;

        len = word.length();
        totalRow = board.length;
        totalColumn = board[0].length;
        marked = new boolean[totalRow][totalColumn];
        char[] words = word.toCharArray();
        for (int i = 0; i < totalRow; i++) {
            for (int k = 0; k < totalColumn; k++) {
                if (board[i][k] == words[0] &&dfs(i, k, 0, board, words))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int row, int column, int charIndex, char[][] board,  char[]  word) {
        if (row >= totalRow || row < 0 || column < 0 || column >= totalColumn || marked[row][column] ||
                board[row][column] != word[charIndex] )
            return false;

        if (charIndex == len - 1){
            return board[row][column] == word[charIndex];
        }

        marked[row][column] = true;
        for (int[] nex : next){
            if (dfs(row + nex[0], column + nex[1], charIndex + 1, board, word))
                return true;
        }

        marked[row][column] = false;
        return false;
    }


    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = new char[][] { {'A', 'B', 'C', 'E'},
                                        {'S', 'F', 'C', 'S'},
                                        {'A', 'D', 'E', 'E'}
                                       };
        System.out.println(w.exist(board,"ABCB"));
    }
}
