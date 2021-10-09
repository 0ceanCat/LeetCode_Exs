package Exs.easy;

/**
 * @author wy
 * @date 2021/7/29 17:06
 */
// 171. Excel表列序号
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        char[] chars = columnTitle.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            res += (chars[i] - 64) * Math.pow(26, len - i - 1);
        }
        return res;
    }
    // AB
    // 26 + 2
    // ZZ
    // 27*27

    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        System.out.println(e.titleToNumber("ABC"));
    }
}
