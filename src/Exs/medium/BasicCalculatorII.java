package Exs.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wy
 * @date 2021/3/10 18:28
 */
// 227. 基本计算器 II
public class BasicCalculatorII {
    public static int calculate(String s) {
        // 定义符号
        char sign = '+';
        // 定义结果
        int res = 0;
        // 定义中间计算值
        int ans = 0;
        // 定义中间计算值
        int num = 0;
        // 定义栈
        Stack<Integer> value = new Stack<>();
        // 遍历循环下标
        int index = 0;
        while(index < s.length()) {
            // 如果是空且不是最后一项
            if(s.charAt(index) == ' ' && index != s.length() - 1) {
                index ++;
                continue;
            }
            // 如果是数字
            if (s.charAt(index)  >= '0' && s.charAt(index)  <= '9') {
                while(index < s.length() && s.charAt(index)  >= '0' && s.charAt(index)  <= '9') {
                    num = num * 10 + s.charAt(index)  - '0';
                    index ++;
                }
            }
            // 如果是符号或者是最后一项
            if (index == s.length() || index == s.length() - 1 || (s.charAt(index)  < '0' && s.charAt(index)  != ' ')){
                switch (sign) {
                    case '+' -> value.push(num);
                    case '-' -> value.push(-num);
                    case '*' -> {
                        ans = value.pop() * num;
                        value.push(ans);
                    }
                    case '/' -> {
                        ans = value.pop() / num;
                        value.push(ans);
                    }
                }
                // 更新符号
                sign = index < s.length() ? s.charAt(index) : sign;
                num = 0;
                index ++;
            }
        }
        // 取出栈中所有值
        while(!value.empty()) {
            res += value.pop();
        }
        return res;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(calculate("3+2*4"));
    }

}
