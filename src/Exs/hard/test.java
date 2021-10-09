package Exs.hard;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        test s1 = new test();
        int[] arr1 = new int[100000];
        int[] arr2 = new int[100000];
        int[] arr3 = new int[100000];
        int[] arr4 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr1[i] = arr2[i] = arr3[i] = arr4[i] = (int)(Math.random() * 800000);
        }

        long start = System.currentTimeMillis();
        s1.sort1(arr1);
        System.out.println("冒泡结束时间：" + ( System.currentTimeMillis() - start ));
        System.out.println("-----------");

        start = System.currentTimeMillis();
        s1.sort2(arr2);
        System.out.println("选择结束时间：" + ( System.currentTimeMillis() - start ));
        System.out.println("-----------");

        start = System.currentTimeMillis();
        s1.sort3(arr3);
        System.out.println("插入结束时间：" + ( System.currentTimeMillis() - start ));
        System.out.println("-----------");

        start = System.currentTimeMillis();
        Arrays.sort(arr4);
        System.out.println("快排结束时间：" + ( System.currentTimeMillis() - start ));
        System.out.println("-----------");
    }

    private int[] sort1(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        return arr;
    }

    private int[] sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//最后一位不必换
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    index = j;
                    min = arr[j];
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }

    public int[] sort3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//第一个元素视为有序数列
            int keep = arr[i];
            int index = i - 1;
            while (index >= 0 && keep < arr[index]) {//越界，或插入元素已经在正确的位置（插入元素的前一个元素比他小）
                arr[index + 1] = arr[index];//后移
                index--;
            }
            arr[index + 1] = keep;
        }
        return arr;
    }
}
