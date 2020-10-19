package Exs.easy;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author Wei
 * @date 2020/10/17 15:28
 * 有序数组的平方
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        int[] res = new int[A.length];
        int index = end;
        while (begin < end){
            int temp1 = A[begin] * A[begin];
            int temp2 = A[end] * A[end];
            if (temp1 > temp2){
                res[index--] = temp1;
                begin++;
            }
            else{
                res[index--] = temp2;
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-4,-1,0,3,10};
        SquaresOfASortedArray s = new SquaresOfASortedArray();
        s.sortedSquares(a);
    }
}
