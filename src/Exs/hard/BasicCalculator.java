package Exs.hard;

import java.util.*;

/**
 * @author wy
 * @date 09/03/2021 16:26
 */
// 224. 基本计算器

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> sign = new Stack<>();
        sign.push(1);
        int ans = 0,num = 0,op = 1;
        for(char c: s.toCharArray()){
            if(c==' ') continue;
            if('0'<=c && c<='9'){
                num = num*10 + (c-'0');
                continue;
            }
            ans += op*num;
            num = 0;
            if(c=='+'){
                op = sign.peek();
            }else if(c=='-'){
                op = -sign.peek();
            }else if(c=='('){
                sign.push(op);
            }else if(c==')'){
                sign.pop();
            }
        }
        ans += op*num;
        return ans;
    }

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        System.out.println(b.calculate("- (31 + (4 + 5))"));
    }
}
