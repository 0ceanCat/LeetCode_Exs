package Exs.medium;

import java.util.Stack;

/**
 * @author Wei
 * @date 2020/11/14 16:57
 * 402. 移掉K位数字
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        //特殊情况全部删除
        if(num.length() == k){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        //遍历数组
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            //移除元素的情况，k--
            while(!stack.isEmpty() && c < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            //栈为空，且当前位为0时，我们不需要将其入栈
            if(stack.isEmpty() && c == '0'){
                continue;
            }
            stack.push(c);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        //这个是最后栈为空时，删除一位，比如我们的10，删除一位为0，按上面逻辑我们会返回""，所以我们让其返回"0"
        if(stack.isEmpty()){
            return "0";
        }
        //反转并返回字符串
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
