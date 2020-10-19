package Exs.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei
 * @date 2020/8/26 10:59
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinationsofaPhoneNumber {

    String[] letters = {"#","#","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return list;
        StringBuilder sb = new StringBuilder();
        fillList(sb,digits,0);
        return list;
    }

    private void fillList(StringBuilder sb, String digits, int i) {
        if (i >= digits.length()){
            list.add(sb.toString());
            return;
        }
        int index = digits.charAt(i) - '0';
        String str = letters[index];
        for (int k = 0; k < str.length(); k++){
            sb.append(str.charAt(k));
            fillList(sb,digits,i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber letterCombinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();
        List<String> list = letterCombinationsofaPhoneNumber.letterCombinations("23");
        System.out.println(list);
    }
}
