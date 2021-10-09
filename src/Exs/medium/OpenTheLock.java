package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/6/24 19:12
 */
// 752. 打开转盘锁
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        return aStar(deadends, target);
    }

    private int normal(String[] deadends, String target){
        if ("0000".equals(target)) return 0;

        Set<Integer> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(toInt(deadend));
        }
        int tg = toInt(target);

        if (deads.contains(tg) || deads.contains(0)) return -1;

        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        list.addLast(0);
        visited.add(0);

        int ans = 0;

        while (!list.isEmpty()){
            int size = list.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int curr = list.pollFirst();
                for (int number : getNumbers(curr)) {
                    if (deads.contains(number) || visited.contains(number)) continue;
                    if (number == tg) return ans;
                    list.addLast(number);
                    visited.add(number);
                }
            }
        }
        return -1;
    }

    private int aStar(String[] deadends, String target){
        if ("0000".equals(target)) return 0;

        Set<Integer> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(toInt(deadend));
        }
        int tg = toInt(target);

        if (deads.contains(tg) || deads.contains(0)) return -1;

        PriorityQueue<Astar> list = new PriorityQueue<>(Comparator.comparingInt(o -> o.f));
        Set<Integer> visited = new HashSet<>();
        list.add(new Astar(0, tg, 0));
        visited.add(0);

        while (!list.isEmpty()){
            int size = list.size();

            for (int i = 0; i < size; i++) {
                Astar curr = list.poll();
                for (int number : getNumbers(curr.status)) {
                    if (deads.contains(number) || visited.contains(number)) continue;
                    if (number == tg) return curr.g + 1;
                    list.add(new Astar(number, tg,curr.g + 1));
                    visited.add(number);
                }
            }
        }
        return -1;
    }

    private int toInt(String str){
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            x = x * 10 + ( str.charAt(i) - '0' );
        }
        return x;
    }
    private List<Integer> getNumbers(int n){
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            int number = getNumber(n, i);
            int i1 = number + 1;
            int temp = setNumber(n, i, i1 > 9 ? 0 : i1);
            list.add(temp);

            i1 = number - 1;
            temp = setNumber(n, i, i1 < 0 ? 9 : i1);

            list.add(temp);
        }
        return list;
    }

    private int getNumber(int n, int position){
        return switch (position) {
            case 4 -> n / 1000;
            case 3 -> n / 100 % 10;
            case 2 -> n / 10 % 10;
            case 1 -> n % 10;
            default -> 0;
        };
    }

    private static int setNumber(int n, int position, int value){
        return switch (position) {
            case 4 -> value * 1000 + n % 1000;
            case 3 -> value * 100 + n % 100 + n / 1000 * 1000;
            case 2 -> value * 10 + n % 10 + n / 100 * 100;
            case 1 -> value + n / 10 * 10;
            default -> 0;
        };
    }


    class Astar {
        int status;
        int f, g, h;

        public Astar(int status, int target, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status, target);
            this.f = this.g + this.h;
        }

        // 计算启发函数
        public int getH(int status, int target) {
            int ret = 0;
            for (int i = 0; i < 4; ++i) {
                int dist = Math.abs(getNumber(status, i) - getNumber(target, i));
                ret += Math.min(dist, 10 - dist);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        OpenTheLock t = new OpenTheLock();
        System.out.println(t.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));

    }
}
