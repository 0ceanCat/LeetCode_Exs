package Exs.hard;

import java.util.*;

/**
 * @author wy
 * @date 2021/8/26 17:03
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> min ;
    PriorityQueue<Integer> max ;
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size())
            max.add(min.remove());
    }

    public double findMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        else
            return max.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(-1);
        System.out.println(f.findMedian());
        f.addNum(-2);
        System.out.println(f.findMedian());
        f.addNum(-3);
        System.out.println(f.findMedian());
        f.addNum(-4);
        System.out.println(f.findMedian());
        f.addNum(-5);
        System.out.println(f.findMedian());

    }
}
