package Exs.medium;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/9/11 22:08
 */
// 678. 有效的括号字符串
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {

        int len = s.length();
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // 当遇到 ' ( ' 时，' ( ' 所在位置的下标入栈
            if (s.charAt(i) == '(') {
                leftStack.push(i);
                // 当遇到 ' * ' 时，' * ' 所在位置的下标入栈
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
                // 当遇到 ' ) ' 时
            } else {
                // 如果leftstack不为空，先消耗'('
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                    // 如果左括号消耗完了
                    // '*'当左括号来用
                    // 检查starStack是不是空
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                    // '*'也消耗完了，现在又遇到')'，故返回false
                } else {
                    return false;
                }
            }
        }

        // 当字符串全部遍历完时
        // 若 starStack 的长度比 leftStack 的长度要小
        // 有剩余的 ' ( '，但 ' * ' 的数量不够了，则一定不会匹配
        if (starStack.size() < leftStack.size()) {
            return false;
            // 如果剩余的 * 的数量大于等于 左括号的数量
            // * 号要么当右括号来用， 要么为空
        } else {
            while (!starStack.isEmpty() && !leftStack.isEmpty()) {

                // 为了消耗剩下的左括号，* 的index 必须要比左括号大，才能在左括号的右边
                if (leftStack.peek() > starStack.peek()) {
                    return false;
                }

                // 消耗一对左括号和*
                leftStack.pop();
                starStack.pop();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }
}
