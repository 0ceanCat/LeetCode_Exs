package Exs.medium;

/**
 * @author Wei
 * @date 2020/8/13 10:33
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings s = new MultiplyStrings();
        System.out.println(s.multiply2("123","456"));
    }

    StringBuilder sb;
    int result = 0;
    int carry = 0;

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        String res = "0";
        for (int i = len1 - 1; i >= 0 ; i--){
            carry = 0;
            sb = new StringBuilder();
            int n1 = chars1[i] - '0';
            sb.append("0".repeat(len1 - 1 - i)); //补0
            for (int k = len2 - 1; k >= 0 ; k--){
                result = n1 * (chars2[k] - '0');
                result = result + carry;
                carry = result / 10;
                result = result % 10;

                sb.append(result);
                if (k == 0 && carry > 0){
                    sb.append(carry);
                }
            }
            res = add(res,sb.reverse().toString());
        }
        return res;
    }

    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry2 = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry2 != 0;
             i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = x + y + carry2;
            carry2 = sum / 10;
            sb.append(sum % 10);
        }
        return sb.reverse().toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

}
