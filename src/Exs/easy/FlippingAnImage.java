package Exs.easy;

/**
 * WY 2021/2/23
 */

//832. 翻转图像
public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int left, right, temp;
        for (int[] line : A) {
            left = 0;
            right = line.length - 1;
            while(left <= right){
                temp = line[left];
                line[left++] = line[right] ^ 1;
                line[right--] = temp ^ 1;
            }
        }
        return A;
    }
}
