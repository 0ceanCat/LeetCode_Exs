package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/6/26 17:01
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        List<Integer> b = new ArrayList<>();

        var lr = true;
        for (int i = board.length - 1; i >= 0; i--){
            if (lr){
                for (var j = 0; j < board[0].length; j++) {
                    b.add(board[i][j]);
                }
            }else{
                for (var j = board[0].length - 1; j >= 0; j--) {
                    b.add(board[i][j]);
                }
            }
            lr = !lr;
        }


        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        int ans = 0;
        while (!q.isEmpty()){
            int size = q.size();
            ans++;
            for (int i = 0; i < size; i++) {
                Integer curr = q.poll();
                for (Integer state : get(b, curr)) {
                    if (visited.contains(state)) continue;
                    if (state == b.size() - 1) return ans;

                    visited.add(state);
                    q.add(state);
                }
            }
        }

        return -1;
    }


    private List<Integer> get(List<Integer> board, Integer state){
        List<Integer> list = new ArrayList<>();
        int temp = state;

        for (int i = 1; i <= 6; i++) {
             temp++;

            if (temp >= board.size()) break;

            if (board.get(temp) != -1){
                list.add(board.get(temp) - 1);
            }else{
                list.add(temp);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        SnakesAndLadders s = new SnakesAndLadders();
        int i = s.snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}});
        System.out.println(i);
     }
}
