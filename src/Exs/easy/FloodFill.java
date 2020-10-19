package Exs.easy;

import java.util.Arrays;

/**
 * @author Wei
 * @date 2020/8/16 11:04
 * 733. 图像渲染
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(newColor == oldColor) return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int origin){
        if (sr < 0 || sc < 0 || sr >= image.length  || sc >= image[0].length || image[sr][sc] != origin || image[sr][sc] == newColor) {
            //说明已经搜索过了.
            return;
        }

        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc,newColor,origin); // 上
        dfs(image, sr + 1, sc,newColor,origin); // 下
        dfs(image, sr, sc - 1,newColor,origin); // 左
        dfs(image, sr, sc + 1,newColor,origin); // 右
    }
    public static void main(String[] args) {
        int[][] i = {{0,0,0},{0,1,1}};
        FloodFill f = new FloodFill();
     //   f.floodFill(i,1,1,1);
        for (int[] a : i)
            System.out.println(Arrays.toString(a));
    }
}
