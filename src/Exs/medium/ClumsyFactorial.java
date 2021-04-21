package Exs.medium;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/3/31 20:49
 */
// 1006. 笨阶乘
public class ClumsyFactorial {

    public static int clumsy(int N) {
        Stack<Integer> s = new Stack<>();
        int res = N, op = 1;
        int i = N - 1;

        while (i > 0) {
            if (op % 4 == 1){
                res *= i--;
            }else if (op % 4 == 2){
                res /= i--;
                if (s.empty())
                    s.push(res);
                else {
                    s.push(s.pop() - res);
                }
                res = i;
            }else if (op % 4 == 3){
                s.push(s.pop() + i--);
                res = i;
            }else {
                i--;
            }
            op++;
        }

        return s.empty() ? res : s.pop() - res;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(2));
        // 12 * 11 / 10 + 9 - 8 * 7 / 6 + 5 - 4 * 3 / 2 + 1
    }
}
