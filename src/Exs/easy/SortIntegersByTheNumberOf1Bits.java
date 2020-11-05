package Exs.easy;

import java.util.Arrays;

/**
 * @author Wei
 * @date 2020/11/5 16:52
 */
public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(newArray);
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray[i] % 10000000;
        }
        return newArray;
    }

}
