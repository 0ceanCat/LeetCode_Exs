package Exs.medium;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/3/19 17:23
 */

// 150. 逆波兰表达式求值
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st_num=new Stack<>();
        for(String s:tokens){
            if(!("/".equals(s)||"*".equals(s)||"+".equals(s)||"-".equals(s)))
                st_num.push(Integer.parseInt(s));
            else{
                int t1=st_num.pop();
                int t2=st_num.pop();
                switch (s) {
                    case "+" -> st_num.push(t1 + t2);
                    case "-" -> st_num.push(t2 - t1);
                    case "*" -> st_num.push(t1 * t2);
                    default -> st_num.push(t2 / t1);
                }
            }
        }
        return st_num.pop();
    }

    public int calc(int a, int b, String op){
        return switch (op) {
            case "+" -> a + b;
            case "-" -> b - a;
            case "*" -> a * b;
            case "/" -> b / a;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"4", "3", "-"}));
    }
}
