package Exs.medium;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/3/11 20:28
 */

// 331. 验证二叉树的前序序列化
public class VerifyPreorderSerializationOfABinaryTree {
    public static boolean isValidSerialization(String preorder) {
        Stack<Boolean> bool = new Stack<>();
        for (int i = 0; i < preorder.length(); i++) {
            if (preorder.charAt(i) == '#'){
                if (bool.empty()) return i == preorder.length() - 1;

                bool.pop();
                i++;
            }
            else {
                while (i < preorder.length() &&preorder.charAt(i) != ','){
                    i++;
                }
                bool.push(true);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
